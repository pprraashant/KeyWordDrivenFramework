package com.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.domain.AtomLink;
import com.domain.Customer;

@Path(value="/customers")
public class CustomerResources {

	private Map<Integer, Customer> customers=
			new ConcurrentHashMap<Integer, Customer>();
	private AtomicInteger counter = 
			new AtomicInteger();
	
	@POST
	@Consumes({"application/xml",MediaType.APPLICATION_JSON ,"application/amdocs-serialized-object" })
	public Response insertCustomer(Customer customer)
	{
		int count=counter.incrementAndGet();
		customer.setId(count);
		customers.put(count, customer);
		URI uri= null;
		try{
			uri =new URI("http://localhost:8084/JarsiDemoWithCXF/customers/"+count);
		}
		catch(URISyntaxException e) {}
		return Response.created(uri).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes({"application/xml",MediaType.APPLICATION_JSON,"application/amdocs-serialized-object" })
	public void updateCustomer(Customer customer,
			@PathParam("id") int identifier) {
		customers.put(identifier, customer);
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteCustomer(Customer customer,
			@PathParam("id") int identifier) {
		customers.remove(identifier);
		return Response
				.ok()
				.entity("Record delete successfuly")
				.type(MediaType.TEXT_PLAIN)
				.build();
	}
	
	@GET
	@Path("/{id}")
	@Produces({"application/xml",MediaType.APPLICATION_JSON,"application/amdocs-serialized-object"})
	public Customer getCustomeridById(@PathParam("id") int identifier,
			@Context UriInfo uriInfo) {
		
		if(identifier <= 0) {
			throw new RuntimeException(
					"identifier should be greater than 0");
		}
		/*
		try
		{
			if(identifier ==0) {
				throw new RuntimeException(
						"identifier should be greater than 0");
			}
		} catch(RuntimeException re)
		{
			throw new WebApplicationException(
					Response
					.status(Status.NOT_FOUND)
					.entity(re.getMessage())
					.build());
		}
		*/
		UriBuilder uriBuilder =uriInfo.getBaseUriBuilder();
		
		uriBuilder.path(CustomerResources.class);
		
		uriBuilder.path(CustomerResources.class,"getCustomeridById");
		
		URI uri=uriBuilder.build(identifier +1);
		
		Customer customer = customers.get(identifier);
		
		AtomLink self = new AtomLink(
				"self",uri.toString(),"application/xml");
		
		customer.setSelf(self);
				return customer;
	}
	
	@GET
	@Produces({"application/xml",MediaType.APPLICATION_JSON,"application/amdocs-serialized-object"})
	public Collection<Customer> getCustomers()
	{
		return customers.values();
	}
}
