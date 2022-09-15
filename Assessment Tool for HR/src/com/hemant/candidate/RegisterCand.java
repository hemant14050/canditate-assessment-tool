package com.hemant.candidate;

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
 * Servlet implementation class RegisterCand
 */
public class RegisterCand extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCand() {
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
		int hrid=Integer.parseInt(request.getParameter("hrid"));
		String name=request.getParameter("name");
		CandData.setName(name);
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String dob=request.getParameter("dob");
		String quali=request.getParameter("quali");
		String year=request.getParameter("year");
		
		try
		{
			Connection con=ConnectDB.getConnect();
			PreparedStatement ps=con.prepareStatement("insert into candidate values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setInt(2, id);
			ps.setInt(3, hrid);
			ps.setString(4, name);
			ps.setString(5, email);
			ps.setString(6, mobile);
			ps.setString(7, dob);
			ps.setString(8, quali);
			ps.setString(9, year);
			ps.setString(10, "NA");
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				PreparedStatement ps1=con.prepareStatement("select cand_id from candidate where cand_name=? and cand_email=?");
				ps1.setString(1, name);
				ps1.setString(2, email);
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					CandData.setCandid(rs.getInt(1));
				}
				
				response.sendRedirect("taketest.jsp");
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
