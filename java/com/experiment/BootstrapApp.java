package com.experiment;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.experiment.model.Address;
import com.experiment.model.Item;
import com.experiment.model.Order;
import com.experiment.model.OrderItem;
import com.experiment.model.User;
import com.googlecode.objectify.ObjectifyService;

@WebListener
public class BootstrapApp implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		ObjectifyService.init();
                ObjectifyService.register(Item.class);
                ObjectifyService.register(User.class);
                ObjectifyService.register(Address.class);
                ObjectifyService.register(Order.class);
                ObjectifyService.register(OrderItem.class);
		// etc...
	} 
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

