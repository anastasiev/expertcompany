package com.expert.servlets;

import com.expert.dao.NamedParametersDaoImpl;
import com.expert.dto.Billing;
import com.expert.dto.Company;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        params.put("contactPhone", request.getParameter("contactPhone"));
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

        if(dao.isPersonExist(params.get("contactEmail"))){
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

        Person person = new Person(params.get("position"), params.get("firstName"),
                params.get("lastName"),params.get("contactPhone"),params.get("contactEmail"),
                params.get("contactSkype"), params.get("contactCity"),params.get("password"));
        System.out.println(person.getEmail());
        dao.addPerson(person);
        person = dao.getPerson(person.getEmail());

        Company company = new Company(person.getId(), params.get("companyName"),
                params.get("companyOffice"), params.get("companyFax"),
                params.get("companyEmail"), params.get("companyBilling"),
                params.get("companyCity"));

        Billing billing = new Billing(person.getId(), params.get("billingMethod"),
                params.get("bankDetails"), params.get("creditCard"),
                params.get("billingCvv"),null);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            billing.setExpDate(formatter.parse(params.get("expDate")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dao.addCompany(company);
        dao.addBilling(billing);
        System.out.println("All right!!!!!!");

        HttpSession session = request.getSession();
        session.setAttribute("person", person);
        session.setAttribute("company", company);
        session.setAttribute("billing", billing);

        response.sendRedirect("success.jsp");
        return;



    }


}
