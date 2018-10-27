package com.experiment.user;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogOutUser", urlPatterns = { "/logout" })
public class LogoutUser extends HttpServlet {
	
	 @Override
	  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 
	    	HttpSession session = req.getSession(false);
	    	if(session != null) {
	    		session.invalidate();
	    	}
	    	

	  }

}
