package edu.austral.lab1.odontobook.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet{
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException  {
	
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
        String password = request.getParameter("password");
       out.println("Checking login<br>");
        if (username == null || password == null) {

            out.print("Invalid paramters ");
        }

        // Here you put the check on the username and password
        if (username.toLowerCase().trim().equals("admin") && password.toLowerCase().trim().equals("admin")) {
            out.println("Welcome " + username + " <a href=\"index.jsp\">Back to main</a>");
            session.setAttribute("username", username);
        }
       else 
           {
          out.println("Invalid username and password");
       }
	
}

}
