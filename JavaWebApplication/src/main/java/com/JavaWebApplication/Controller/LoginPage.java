package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.RegisterBean;
import com.JavaWebApplication.Beans.LoginBean;
import com.JavaWebApplication.Model.UserDb;

/**
 * Servlet implementation class LoginPage
 */
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
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
		
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginBean lb = new LoginBean(email,password);
		lb.setEmail(email);
		lb.setPassword(password);
		
		UserDb ud = new UserDb();
		String s1 = ud.searchUser(lb);
		System.out.println(s1);
		if(s1=="You have succesfully Logged in")
		{
			System.out.print(" Hey Welcome");
			response.sendRedirect("http://localhost:8085/JavaWebApplication/trialwelcome.jsp");
		}
	}

}
