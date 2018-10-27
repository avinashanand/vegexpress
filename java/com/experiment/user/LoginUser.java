package com.experiment.user;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.experiment.model.Address;
import com.experiment.model.User;
import com.experiment.model.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.objectify.Result;

@WebServlet(name = "LoginUser", urlPatterns = { "/login" })
public class LoginUser extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Result<User> loaduser = ofy().load().type(User.class).id(email);
		User dbuser = loaduser.now();
		if (dbuser.getPassword().equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("Name", dbuser.getEmail());
			session.setAttribute("Mobile", dbuser.getMobile());
			dbuser.setLastLogin(new Date());
			ofy().save().entity(dbuser).now();
			
			ObjectMapper mapper = new ObjectMapper(); 
			
			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8");
			UserResponse usr = new UserResponse(dbuser.getUserId(), dbuser.getEmail(), dbuser.getMobile(), dbuser.getAddress());
			resp.getWriter().print(mapper.writeValueAsString(usr));
		}else{
			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8");

			resp.getWriter().print("User login failed");
		}
			

	}

}
