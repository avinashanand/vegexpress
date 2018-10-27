package com.experiment.order;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;

import com.experiment.Orders;
import com.experiment.model.Item;
import com.experiment.model.Order;
import com.experiment.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.objectify.Result;


@WebServlet(
	    name = "CreateOrder",
	    description = "OrderAPI: Create Order",
	    urlPatterns = "/createorder"
	)
public class CreateOrder extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
    
	 if(request.getSession(false) != null){
	    	String userEmail = (String) request.getSession().getAttribute("Name");
	    	Result<User> loaduser = ofy().load().type(User.class).id(userEmail);
	    	
	    	User myUser = loaduser.now();
	    	
	    	ObjectMapper mapper = new ObjectMapper(); 
	    	Order order = mapper.readValue(request.getReader(), Order.class);
	    	order.setOrderBy(myUser);
	    	
	    	validate(order);
	    	order.setStatus(Orders.ACCEPTED);
	    	ofy().save().entity(order).now(); 
	    	
	    	String jsonInString = mapper.writeValueAsString(order);
	    	
	    	response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			response.getWriter().print(jsonInString);
	 }
	 else{
		 response.setStatus(HttpStatus.SC_UNAUTHORIZED);
		 response.getWriter().print("Login to place order");
	 }
		 
	 
	  
	
	

  }
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
	  response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	   
	    response.getWriter().print("API Hit");
  }
  private void validate(Order order){
	 // @TODO write code for server side price and quantity validation.
  }
  
  
}