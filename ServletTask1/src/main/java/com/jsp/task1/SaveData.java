package com.jsp.task1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/save")
public class SaveData extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String address=req.getParameter("address");
		String password=req.getParameter("password");
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(address);
		System.out.println(password);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/task","root","root");
			PreparedStatement ps=con.prepareStatement("insert into store(id,name,phone,email,address,password) values(?,?,?,?,?,?)");
			
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2,name);
			ps.setLong(3,Long.parseLong(phone));
			ps.setString(4, email);
			ps.setString(5,address);
			ps.setString(6, password);
			ps.execute();
			
			PrintWriter p=res.getWriter();
			p.print("<h1> data inserted successfully</h1><br>");
			p.print("<a href='save.html'>Click here to save again</a>");	
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}
