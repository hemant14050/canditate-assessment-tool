package com.hemant.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	
	static Connection con=null;
	public static Connection getConnect()
	{
		if(con==null)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assessment_tool_hr", "root", "");
			} 
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return con;
	}
}
