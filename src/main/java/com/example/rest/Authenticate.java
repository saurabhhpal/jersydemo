package com.example.rest;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.example.dao.DataAccessLayer;
import com.example.model.Token;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;

@Path("/addAuth")
public class Authenticate {

	
	@POST
	@Path("/authenticate")
	public Response login(@QueryParam("phone") Integer phone , @QueryParam("pass") String pass)
	{
		try {
			
			byte[] encoded =Base64.encodeBase64(pass.getBytes());
			String encryptedPass= new String(encoded);
			DataAccessLayer accessLayer= new DataAccessLayer();
			Token token= accessLayer.getCandidate(phone);
			if(token.getPass().equals(encryptedPass))
					{	String token1=UUID.randomUUID().toString();
					accessLayer.createToken(token,token1);
					}
			else
			{
				System.out.println("invalid credentials" );
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return Response.status(200).entity("success").build();
	}
	
	
	
	@GET
	@Produces("text/plain")
	@Path("/verify")
	public String verify(@HeaderParam("Auth-Key") String token) throws Exception{
		
		DataAccessLayer accessLayer= new DataAccessLayer();
		boolean verified= accessLayer.verifyToken(token);
		if(verified) {
			return "success";
			
		}else
			return "failure";
			
				
		
	}
}
