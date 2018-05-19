package com.test;

import java.util.Collection;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.domain.Customer;

public class TestGetAllCustomer {
	
	public static void main(String []args)
	{
		Client client= ClientBuilder.newClient();
		
		WebTarget target = 
				client.target("http://localhost:8084/JarsiDemo/")
				.path("customers");
				
				
		Invocation.Builder builder = target.request(
				MediaType.APPLICATION_XML);
		
		Response response =builder.get();
				
		
		System.out.println(response.getStatus());
		
		Collection<Customer> customer=
				response.readEntity(
						new GenericType<Collection<Customer>>(){});
		
		System.out.println(customer.toString());
		client.close();
	}


}
