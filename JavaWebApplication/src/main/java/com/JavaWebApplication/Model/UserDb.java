package com.JavaWebApplication.Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.JavaWebApplication.Beans.LoginBean;
import com.JavaWebApplication.Beans.RegisterBean;
public class UserDb 
{
	String s1=null;
	public String insertUSer(RegisterBean rb) 
	{
		MyDb db = new MyDb();
		Connection con = db.getCon();
		try 
		{ 
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into register(name,email,password) values('"+rb.getName()+"','"+rb.getEmail()+"','"+rb.getPassword()+"')");
			s1="Data Inserted"; 
		}
		catch(SQLException e) 
		{
			e.printStackTrace(); 
		}
		return s1; 
	}
	public String searchUser(LoginBean lb) 
	{
		String s1 = "Hi";
		MyDb db = new MyDb();
		Connection con = db.getCon();
		try 
		{ 
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from register where email='"+lb.getEmail()+"' and password='"+lb.getPassword()+"'");
			if(rs.next())
			{
				s1="You have succesfully Logged in"; 
			}
			else
			{
				s1="Sorry";
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace(); 
		}
		return s1; 
	}
}
