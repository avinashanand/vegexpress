package com.experiment.service;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.experiment.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(
    name = "SaveEntity",
    urlPatterns = {"/save"}
)
public class SaveEntity extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
    
	ObjectMapper mapper = new ObjectMapper(); 
	Item item = mapper.readValue(request.getReader(), Item.class);
	
	ofy().save().entity(item).now(); 
	
	assert item.getId() != null;
	
	List<Item> result = ofy().load().type(Item.class).list();
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
    String jsonInString = mapper.writeValueAsString(result);
    response.getWriter().print(jsonInString);

  }
}