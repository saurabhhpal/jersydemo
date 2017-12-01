package com.example.model;

import java.sql.Connection;
import java.util.ArrayList;

import javax.ws.rs.core.Response;

import com.example.dao.DataAccessLayer;
import com.example.dao.Database;

public class CandidateManager {
	
	public ArrayList<Candidate> getCandidates(String name) throws Exception
	{
	ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		Database db= new Database();
	Connection con=db.getConnection();
	DataAccessLayer access=new DataAccessLayer();
	
	candidateList=access.getCandidates(con,name);
	return candidateList;
	
	}
	
	public String addCandidates(Candidate candidate) throws Exception
	{
			
		Database db= new Database();
		Connection con=db.getConnection();
		DataAccessLayer access=new DataAccessLayer();
		
		String msg=access.addCandidates(con, candidate);
	//	System.out.println(msg);
		return msg;		
				
			
	}
	

public String deleteCandidate(String name) throws Exception
{
	Database db= new Database();
	Connection connection= db.getConnection();
	DataAccessLayer access= new DataAccessLayer();
	String msg =access.deleteCandidate(connection,name);
	
	return "deleted candidate is "+ msg;
	
}
}
//	public void addAuth(Token token) throws Exception
//	{
//		Database db= new Database();
//		Connection con= db.getConnection();
//		DataAccessLayer access = new DataAccessLayer();
//		access.addAuth(con, token);
//	}