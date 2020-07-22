package com.tutorial.jee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tutorial.login.LoginService;


/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	
	LoginService service = new LoginService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	/*	PrintWriter writer = response.getWriter();
		writer.println("Dummy Stuff");
		request.setAttribute("name",request.getParameter("name"));
		request.setAttribute("password",request.getParameter("password"));*/
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		boolean valid = service.isUserValid(name, password);
		
		if(valid) {
			request.setAttribute("name",name);
			request.setAttribute("password",password);
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}else {
			request.setAttribute("errormsg","Invalid Credentials!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
		

	}

}