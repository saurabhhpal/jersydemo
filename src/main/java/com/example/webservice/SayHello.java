package com.example.webservice;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;


import com.example.dao.Candidate;
import com.example.model.CandidateManager;
import com.google.gson.Gson;

@Path("/hello")
public class SayHello {
	
	
	ArrayList<Candidate> candidateArr= new ArrayList<Candidate>();
	
	@Context
	UriInfo uriInfo;
	
	  @Context
	  Request request;
	  
	
	@GET
	@Path("/plain")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloPlain()
	{
		return "hello ";
	}
	
	@GET
	@Path("/candidates/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String CandidateList(@PathParam("name") String name)
	{
		String candidates=null ;
		
		try {
			candidateArr= new CandidateManager().getCandidates(name);
			Gson gson=new Gson();
			candidates=gson.toJson(candidateArr);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return candidates;
	}
	
	

}
