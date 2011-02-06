package com.cunningstunts.abstemious.backend;
import java.io.IOException;
import javax.servlet.http.*;

import com.cunningstunts.abstemious.shared.dao.User;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class DebugServlet extends HttpServlet {
  
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Objectify ofy = ObjectifyService.begin();
		
		User user = new User("IYER");
		ofy.put(user);
		
		Query<User> results = ofy.query(User.class).filter("name = ", "IYER");
    resp.setContentType("text/plain");
		for (User result: results) {
		  resp.getWriter().println(result);
		}
	}
}