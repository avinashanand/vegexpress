package com.experiment;

import javax.servlet.annotation.WebFilter;

import com.googlecode.objectify.ObjectifyFilter;
/**
 * Servlet Filter implementation class ObjectifyWebFilter
 */
@WebFilter(urlPatterns = {"/*"})
public class ObjectifyWebFilter extends ObjectifyFilter  {

	
    
}
