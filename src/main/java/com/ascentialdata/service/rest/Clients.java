package com.ascentialdata.service.rest;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ascentialdata.service.rest.entity.Pong;

public class Clients {
	
	public static void main (String args[]) {
		
	Client client = ClientBuilder.newClient();
	
	WebTarget webTarget = client.target("http://localhost:8080/REST_Example");
	WebTarget pingWebTarget = webTarget.path("/rest/ping");
	
	Invocation.Builder invocationBuilder = pingWebTarget.request(MediaType.APPLICATION_XML);
	Response response = invocationBuilder.get();
	
	 Pong p = response.readEntity(Pong.class);
	 
	 
	
	
	System.out.println(response.getStatus());
	System.out.println(p.getEnvironmnet());
		
	
	
	}
}