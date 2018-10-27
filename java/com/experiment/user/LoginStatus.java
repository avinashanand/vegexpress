package com.experiment.user;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;

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

@WebServlet(name = "StatusAPI", description = "UserAPI: Login / Logout with UserService", urlPatterns = "/status")
public class LoginStatus extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		if (req.getSession(false) != null) {
			HttpSession session = req.getSession(false);

			Result<User> loaduser = ofy().load().type(User.class).id(session.getAttribute("Name").toString());
			User dbuser = loaduser.now();

			ObjectMapper mapper = new ObjectMapper();

			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8");
			UserResponse usr = new UserResponse(dbuser.getUserId(), dbuser.getEmail(), dbuser.getMobile(), dbuser.getAddress());
			resp.getWriter().print(mapper.writeValueAsString(usr));
		} else
			resp.getWriter().print("loggedout");
	}

}
