package com.pu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.*;

@WebServlet("/register")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;   
    
    public UserController() {
        super();
    }
    public void init() {
        userDao = new UserDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 register(request, response);
	}
	 private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	User user = new User();
	user.setFirstName(firstName);
	user.setLastName(lastName);
	user.setUsername(username);
	user.setPassword(password);

	userDao.saveUser(user);
RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
     dispatcher.forward(request, response);
   }
}

