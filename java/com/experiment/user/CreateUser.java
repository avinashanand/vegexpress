package com.experiment.user;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.experiment.model.Item;
import com.experiment.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.objectify.Result;


@WebServlet(
	    name = "CreateUserAPI",
	    description = "UserAPI: Login / Logout with UserService",
	    urlPatterns = "/createuser"
	)
public class CreateUser extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
    
	ObjectMapper mapper = new ObjectMapper(); 
	User user = mapper.readValue(request.getReader(), User.class);
	if(validateUser(user)){
		ofy().save().entity(user).now(); 
		assert user.getEmail() != null;
		
		
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	   
	    response.getWriter().print("User created");
	}else{
		
		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	   
	    response.getWriter().print("User creation failed");
		
	}
	

  }
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
	  response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	   
	    response.getWriter().print("API Hit");
  }
  
  private boolean validateUser(User user){
	 boolean flag = false;
	 if (user.getEmail() != null && !user.getEmail().isEmpty()){
		 Result<User> loaduser = ofy().load().type(User.class).id(user.getEmail());
		 if(loaduser.now() == null)
			 if (user.getUserId() != null && !user.getUserId().isEmpty())
				 if (user.getPassword() != null && !user.getPassword().isEmpty())
					 if (user.getMobile() != null && !user.getMobile().isEmpty())
						 flag =true; 
	 }
		 
	return flag; 
  }
}