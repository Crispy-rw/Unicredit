package com.academy.core.servlets;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.Date;

import com.academy.core.servlets.user.User;
import com.google.gson.Gson;

/**
 * @author Anirudh Sharma
 * 
 * Servlet to consume the Sling Model
 */
@Component(service = Servlet.class, 
        property = { 
        Constants.SERVICE_DESCRIPTION + "=Sling Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, 
        "sling.servlet.paths=" + "/bin/users" })
public class GetUser extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 7558680464517017317L;

    private Gson gson = new Gson();
	
	/**
	 * Overridden method
	 */
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws java.io.IOException  {

	    User user = new User();
        user.setId(100);
        user.setFirstName("Ramesh");
        user.setLastName("Fadatare");
        user.setCreatedAt(new Date());
        user.setCreatedBy("Admin");
        user.setEmailId("ramesh@gmail.com");
        user.setUpdatedAt(new Date());
        user.setUpdatedby("Admin");

        String userJsonString = this.gson.toJson(user);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(userJsonString);
        out.flush();

	}

}