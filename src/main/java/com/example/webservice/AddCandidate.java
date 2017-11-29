package com.example.webservice;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.example.dao.Candidate;
import com.example.model.CandidateManager;

@Path("/add")
public class AddCandidate {
	
	@Context
	  UriInfo uriInfo;
	  @Context
	  Request request;
	
	@POST
	@Path("/addcandidates")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addCandidates(@FormParam("_name") String name, @FormParam("_pass") String pass,
			@FormParam("_phone") Integer phone, @FormParam("_email") String email,@FormParam("_city") String city) throws Exception 
	
	{	
		
		Candidate candidate =new Candidate();
		candidate.setName(name);
		candidate.setPass(pass);
		candidate.setPhone(phone);
		candidate.setCity(city);
		candidate.setEmail(email);
		
		CandidateManager candidateManager=new CandidateManager();
		
			String msg=candidateManager.addCandidates(candidate);
			if(msg.equals("failure"))
				return Response.status(500).entity(msg).build();
			else
				return Response.status(200).entity(msg).build();
//			System.out.println("creating Candidate");
//	        System.out.println("name: " + name);
//	        System.out.println("email: " + pass);
	             
	}
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 
	public Response deleteCandidates(@FormParam("_name") String name) throws Exception
	{
		CandidateManager candidateManager= new CandidateManager();
		String msg=candidateManager.deleteCandidate(name);
		//System.out.println(name);
		if(msg.equals("failure"))
			return Response.status(500).entity(msg).build();
		else
			return Response.status(200).entity(msg).build();
		
		//return msg;
	}

}
