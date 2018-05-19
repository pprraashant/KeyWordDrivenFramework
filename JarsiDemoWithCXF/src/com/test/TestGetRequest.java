package com.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.domain.Customer;

public class TestGetRequest {
	
	public static void main(String []args)
	{
		Client client= ClientBuilder.newClient();
		
		WebTarget target = 
				client.target("http://localhost:8084/JarsiDemo")
				.path("customers")
				.path("1");
				
				
		Invocation.Builder builder = target.request(
				MediaType.APPLICATION_XML);
		
		Response response =builder.get();
				
		
		System.out.println(response.getStatus());
		System.out.println(
				response.readEntity(Customer.class).getName());
		client.close();
	}


}
