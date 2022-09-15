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
import com.hemant.hr.JobData;

/**
 * Servlet implementation class CalculateScore
 */
public class CalculateScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateScore() {
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
		
		String[] ans=new String[21];	
		
		for(int i=1;i<=20;i++)
		{
			ans[i]=request.getParameter("q"+i);
			
		}
		
		int O=0,C=0,E=0,A=0,N=0;
		
		for(int i=1;i<=20;i++)
		{
			if(ans[i].equals("O"))
				O++;
			else if(ans[i].equals("C"))
				C++;
			else if(ans[i].equals("E"))
				E++;
			else if(ans[i].equals("A"))
				A++;
			else
				N++;
				
		}
		
		try
		{
			Connection con=ConnectDB.getConnect();
			PreparedStatement ps=con.prepareStatement("select job_qualities from jobs where job_id=?");
			ps.setInt(1, JobData.getJobid());
			ResultSet rs=ps.executeQuery();
			String quali=null;
			
			while(rs.next())
			{
				quali=rs.getString("job_qualities");
			}
			
			int pass=7;
			if(quali.equals("O") && O>pass || quali.equals("C") && C>pass || quali.equals("E") && E>pass || quali.equals("A") && A>pass || quali.equals("N") && N>pass)
			{
				PreparedStatement ps1=con.prepareStatement("update candidate set status=? where cand_id=?");
				ps1.setString(1, "Shortlisted");
				ps1.setInt(2, CandData.getCandid());
				int i=ps1.executeUpdate();
				
				if(i>0)
				{
					response.sendRedirect("Congratulations.jsp");
				}
				else
				{
					response.sendRedirect("soory.jsp");
				}
				
			}
			else
			{
				PreparedStatement ps1=con.prepareStatement("update candidate set status=? where cand_id=?");
				ps1.setString(1, "Not Shortlisted");
				ps1.setInt(2, CandData.getCandid());
				int i=ps1.executeUpdate();
				response.sendRedirect("soory.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
