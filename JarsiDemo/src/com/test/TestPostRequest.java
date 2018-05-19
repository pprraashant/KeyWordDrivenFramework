package com.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.domain.Customer;

public class TestPostRequest {
	public static void main(String []args)
	{
		Customer customer= new Customer();
		customer.setName("John");
		customer.setBalance(123434);
		
		Client client= ClientBuilder.newClient();
		
		WebTarget target = 
				client.target("http://localhost:8084/JarsiDemo").path("customers");
				
				
		Invocation.Builder builder = target.request();
		
		Response response =builder.post(
				Entity.entity(customer, MediaType.APPLICATION_XML));
		
		System.out.println(response.getStatus());
		System.out.println(response.getHeaderString("Location"));
	}

}
