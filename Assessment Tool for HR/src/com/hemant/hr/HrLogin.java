package com.hemant.hr;

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
 * Servlet implementation class HrLogin
 */
public class HrLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HrLogin() {
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
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		try
		{
			Connection con=ConnectDB.getConnect();
			PreparedStatement ps=con.prepareStatement("select * from hr_tbl where hr_email=? and hr_pass=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				HrData.setId(rs.getInt(1));
				HrData.setName(rs.getString(2));
				HrData.setEmail(rs.getString(3));
				response.sendRedirect("hrmenu.jsp");
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
