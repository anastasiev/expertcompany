package com.expert.servlets;

import com.expert.dto.Person;
import com.expert.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Shylov Denis on 14.03.2016.
 */
@WebServlet("/logins")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId;
        String passwordId;

        userId = req.getParameter("userId");
        passwordId = req.getParameter("passwordId");
        System.out.println(userId + " + " + passwordId);
        LoginService loginService = new LoginService();
        boolean result = loginService.authenticate(userId, passwordId);
        if (result) {
            Person person = loginService.getUserDetails(userId);
            req.setAttribute("user", person);
//            resp.sendRedirect("success.jsp");
            RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");
            dispatcher.forward(req,resp);
            return;
        }
        else {
            resp.sendRedirect("login.jsp");
            return;
        }
    }
}