package com.hemant.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hemant.dbconnect.ConnectDB;

/**
 * Servlet implementation class AddHr
 */
public class AddHr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHr() {
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
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String des=request.getParameter("des");
		String mobile=request.getParameter("mobile");
		String pass=request.getParameter("pass");
		
		try
		{
			Connection con=ConnectDB.getConnect();
			PreparedStatement ps=con.prepareStatement("insert into hr_tbl values(?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, mobile);
			ps.setString(5, pass);
			ps.setString(6, des);
			int i=ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("addhrsuccess.html");
			}
			else
			{
				response.sendRedirect("addhrfailed.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
