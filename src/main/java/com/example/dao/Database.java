package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
public class Database {
	
	public Connection getConnection() throws Exception 
	{	String connectionURL=null;
		Connection connection = null;
			try
			{
//				if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//					    // Load the class that provides the new "jdbc:google:mysql://" prefix.
//					    Class.forName("com.mysql.jdbc.GoogleDriver");
//					     connectionURL = "jdbc:google:mysql://35.200.253.139:3306/test1?user=root";
//					     connection = DriverManager.getConnection(connectionURL,"root","root");
//				}
//				else {
//							
				 connectionURL = "jdbc:mysql://35.200.253.139:3306/test1";
				 Class.forName("com.mysql.jdbc.Driver");
				
				//String connectionURL = "jdbc:google:mysql://saurabhpyaal:asia-south1:test1/test1?user=root";
				//"jdbc:mysql://google/test1?cloudSqlInstance=saurabhpyaal:asia-south1:test1&amp;socketFactory=com.google.cloud.sql.mysql.SocketFactory&amp;user=root&amp;password=$root&amp;useSSL=false
				
				//Class.forName("com.mysql.jdbc.GoogleDriver");
				
				//}
				 
				
				connection = DriverManager.getConnection(connectionURL,"root","root");
				
			
		}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return connection;
		}
	}


