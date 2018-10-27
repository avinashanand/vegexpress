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

@WebServlet(name = "ListEntity", urlPatterns = { "/list" })
public class ListEntity extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String item = request.getParameter("item");
		List<Item> result;
		ObjectMapper mapper = new ObjectMapper();

		if (item != null && !item.isEmpty()) {
			result = ofy().load().type(Item.class).filter("type", item).list();
		} else
			result = ofy().load().type(Item.class).list();
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String jsonInString = mapper.writeValueAsString(result);
		response.getWriter().print(jsonInString);

	}
}