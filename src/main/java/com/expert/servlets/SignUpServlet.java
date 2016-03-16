package com.expert.servlets;

import com.expert.service.SignUpService;

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

        for (Map.Entry<String, String> entry : params.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        SignUpService signUpService = new SignUpService();
        boolean result = signUpService.registration(params);

        if (result) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
            dispatcher.forward(request,response);
            return;
        }
        else {
            response.sendRedirect("signup.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
