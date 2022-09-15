package com.hemant.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hemant.dbconnect.ConnectDB;

/**
 * Servlet implementation class DeleteHr
 */
public class DeleteHr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteHr() {
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
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		
		try
		{
			Connection con=ConnectDB.getConnect();
			PreparedStatement ps=con.prepareStatement("delete from hr_tbl where hr_id=? and hr_name=?");
			ps.setInt(1, id);
			ps.setString(2, name);
			int i=ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("success.html");
			}
			else
			{
				response.sendRedirect("failed.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
