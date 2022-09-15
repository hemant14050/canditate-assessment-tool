package com.hemant.hr;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hemant.dbconnect.ConnectDB;

/**
 * Servlet implementation class AddJob
 */
public class AddJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String title=request.getParameter("title");
		String des=request.getParameter("des");
		String sal=request.getParameter("sal");
		String qual=request.getParameter("qual");
		String exp=request.getParameter("exp");
		
		try
		{
			Connection con=ConnectDB.getConnect();
			PreparedStatement ps=con.prepareStatement("insert into jobs values(?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setInt(2, HrData.getId());
			ps.setString(3, title);
			ps.setString(4, des);
			ps.setString(5, sal);
			ps.setString(6, qual);
			ps.setString(7, exp);
			int i=ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("jobaddsucc.html");
			}
			else
			{
				response.sendRedirect("jobaddfail.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
