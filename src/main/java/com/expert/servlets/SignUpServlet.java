package com.expert.servlets;

import com.expert.dao.NamedParametersDaoImpl;
import com.expert.dto.Person;
import com.expert.service.SignUpService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dmytro on 13.03.16.
 */
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("position", request.getParameter("position"));
        params.put("firstName", request.getParameter("firstName"));
        params.put("lastName", request.getParameter("lastName"));
        params.put("contactEmail", request.getParameter("contactEmail"));
        params.put("contactCity", request.getParameter("contactCity"));
        params.put("contactSkype", request.getParameter("contactSkype"));
        params.put("password", request.getParameter("password"));
        params.put("companyName", request.getParameter("companyName"));
        params.put("companyOffice", request.getParameter("companyOffice"));
        params.put("companyFax", request.getParameter("companyFax"));
        params.put("companyEmail", request.getParameter("companyEmail"));
        params.put("companyBilling", request.getParameter("companyBilling"));
        params.put("companyCity", request.getParameter("companyCity"));
        params.put("billingMethod", request.getParameter("billingMethod"));
        params.put("bankDetails", request.getParameter("bankDetails"));
        params.put("creditCard", request.getParameter("creditCard"));
        params.put("billingCvv", request.getParameter("billingCvv"));
        params.put("expDate", request.getParameter("expDate"));

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        NamedParametersDaoImpl dao = ctx.getBean("namedParametersDaoImpl", NamedParametersDaoImpl.class);

        if(dao.isLogin(params.get("contactEmail"), params.get("password"))){
            response.sendRedirect("signup.jsp");
            return;
        }

        if(dao.isCompanyExist(params.get("companyName"))){
            response.sendRedirect("signup.jsp");
            return;
        }

        if(dao.isBillingExist(params.get("creditCard"))){
            response.sendRedirect("signup.jsp");
            return;
        }
        //Добавь Phone в регестрацию!!!!

//        Person person = new Person(params.get("position"), params.get("firstName"),
//                params.get("lastName"),params.get("email"),params.get("skype"),
//                params.get("city"),params.get("pasword"));



    }


}
