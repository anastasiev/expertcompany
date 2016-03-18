package com.expert.servlets;

import com.expert.dao.NamedParametersDaoImpl;
import com.expert.dto.Billing;
import com.expert.dto.Company;
import com.expert.dto.Person;
import com.expert.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Shylov Denis on 14.03.2016.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("passwordId");;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        NamedParametersDaoImpl dao = ctx.getBean("namedParametersDaoImpl", NamedParametersDaoImpl.class);

        if(dao.isLogin(email, password)){
            Person person = dao.getPerson(email);
            Company company = dao.getCompany(person.getId());
            Billing billing = dao.getBilling(person.getId());
            HttpSession session = req.getSession();
            session.setAttribute("person", person);
            session.setAttribute("company", company);
            session.setAttribute("billing", billing);
            resp.sendRedirect("success.jsp");
            return;
        }
        resp.sendRedirect("login.jsp");


    }
}