<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hemant.dbconnect.ConnectDB"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Job</title>
</head>
<body>

<%
	int id=Integer.parseInt(request.getParameter("id"));
	try
	{
		Connection con=ConnectDB.getConnect();
		PreparedStatement ps=con.prepareStatement("delete from jobs where job_id=?");
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("viewjob.jsp");
		}
		else
		{
			response.sendRedirect("viewjob.jsp");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>

</body>
</html>