package com.jsp.task1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@WebServlet("/login")
public class Login extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","root");
			PreparedStatement ps=con.prepareStatement("select * from store where email=?and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				
//				RequestDispatcher rd=req.getRequestDispatcher("welcome.html");
//				rd.forward(req, res);
//				---->
				PrintWriter out = res.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Login Successful');");
                out.println("window.location='welcome.html';");
                out.println("</script>");
				
			}
			else
			{
				PrintWriter pw=res.getWriter();
				pw.print("<h1>Invalid</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("response.html");
				pw.print("<a href='response.html'>Click here to login again</a>");
			}
				
		 
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
		
		}}

	
	}
		