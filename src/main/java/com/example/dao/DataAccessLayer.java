package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataAccessLayer {
	

ResultSet rs=null;
	public ArrayList<Candidate> getCandidates(Connection connection,String name) throws SQLException{
		
		
	ArrayList<Candidate> candidateList =new ArrayList<Candidate>();

	String sql="select * from candidate where name=?";
	PreparedStatement psmt =connection.prepareStatement(sql);
	psmt.setString(1, name);
	rs=psmt.executeQuery();
	try {
		while(rs.next())
		{
			Candidate candidateObj = new Candidate();
			candidateObj.setName(rs.getString("name"));
			candidateObj.setPass(rs.getString("pass"));
			candidateObj.setEmail(rs.getString("email"));
			candidateObj.setPhone(rs.getInt("phone"));
			candidateObj.setCity(rs.getString("city"));
			candidateList.add(candidateObj);
			
			
		}
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	return candidateList;

}
	
	
	public String  addCandidates(Connection connection, Candidate candidate) throws Exception
	{
		
		String sql="insert into candidate values (?,?,?,?,?)";
		try {
			
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		
			preparedStatement.setString(1, candidate.name);
			preparedStatement.setString(2, candidate.pass);
			preparedStatement.setInt(3, candidate.phone);
			preparedStatement.setString(4, candidate.city);
			preparedStatement.setString(5, candidate.email);
			preparedStatement.executeUpdate();
			return "success";
			
		}catch (Exception e) {
		      System.err.println("Got an exception!"+e.getStackTrace());
		      System.err.println(e.getMessage());
		      return "failure";
		     
			}
		 finally {
	    	  connection.close();
		}	
	}
	
	
	public String deleteCandidate(Connection connection, String name) throws Exception
	{	PreparedStatement preparedStatement=null;
		String sql= "delete from candidate where name=?";
		try
		{
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setString(1,name);
				int rows=preparedStatement.executeUpdate();
				System.out.println(rows + name );
		if(rows!=0)
			{
			//System.out.println("IN Try");
			System.out.println("IN if");
			return name;
			}
		else
			{System.out.println("IN esle");
			return "sorry";}
		}catch (Exception e) {
				System.err.println("Got an Exception "+e.getStackTrace());
				System.err.println(e.getMessage());
				return "failure";
		}
		 finally {
	    	  connection.close();
		}	
	}
	
	//For token

	public Token getCandidate(Integer Phone) throws Exception
	{
		String sql="select * from token where phone=(?)";
		Database database= new Database();
		Token token= new Token();
		try {
			PreparedStatement preparedStatement= database.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, Phone);
			ResultSet rs= preparedStatement.executeQuery();
			rs.next();
			
			token.setPhone(rs.getInt("phone"));
			token.setPass(rs.getString("pass"));
			return token;
		
		}
		catch (Exception e) {
			throw new Exception();
		}
		
		
	}


	public void createToken(Token token,String token1) {
		
		String  sql= " insert into token values where phone=(?,?,?)";
		try {
			Connection connection = new Database().getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, token.getPhone());
			preparedStatement.setString(2, token.getPass());
			preparedStatement.setString(3, token.getToken());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
				
		
	}


	public boolean verifyToken(String token) throws Exception{
String sql="select token from token where token=(?) ";
		try {
			Connection connection= new Database().getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			ResultSet rs=preparedStatement.executeQuery();
			rs.next();
			String string=rs.getString("token");
			
			if(string!= null)
				return true;
			else
				return false;
			
		
			
		}catch (SQLException e) {
			throw new Exception(e);
		
		}
		
			
	}
	
	
	
	
}
