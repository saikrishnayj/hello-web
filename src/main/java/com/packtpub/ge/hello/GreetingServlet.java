package com.packtpub.ge.hello;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {
GreetingService service = new GreetingService();

@Override
public void doPost(HttpServletRequest req, HttpServletResponse res) 
throws ServletException, IOException {
String name = req.getParameter("name");
String message = service.greet(name);
req.setAttribute("message",message);
RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/WEB-INF/greet.jsp");
dispatch.forward(req,res);
}
}
