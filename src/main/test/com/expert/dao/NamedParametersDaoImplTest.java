package com.expert.dao;

import com.expert.dto.Billing;
import com.expert.dto.Company;
import com.expert.dto.Person;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by dmytro on 14.03.16.
 */
public class NamedParametersDaoImplTest {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    NamedParametersDaoImpl dao = ctx.getBean("namedParametersDaoImpl", NamedParametersDaoImpl.class);

    @org.junit.Test
    public void testAddPerson() throws Exception {

        Person p = new Person("aaa","aaa", "aaa", "aaa", "aaa", "aaa", "aaa", "aaa");
        dao.addPerson(p);
    }


    @Test
    public void testAddCompany() throws Exception {
        Company company = new Company(5,"ccc", "ccc", "ccc","cccc", "cccc", "ccc");
        dao.addCompany(company);

    }

    @Test
    public void testAddBilling() throws Exception {

        Billing billing = new Billing(5,"scc","dfdcd","12345567","123",new Date());
        dao.addBilling(billing);
    }

    @Test
    public void testIsLogin() throws Exception {

        System.out.println(dao.isLogin("aaa", "aaa"));
        System.out.println(dao.isLogin("bbb", "bbb"));
        System.out.println(dao.isLogin("ccc", "ccc"));
    }

    @Test
    public void testIsCompanyExist() throws Exception {
        System.out.println(dao.isCompanyExist("dcdc"));
        System.out.println(dao.isCompanyExist("dfv"));
        System.out.println(dao.isCompanyExist("ikhbjkb"));
    }

    @Test
    public void testGetCompany() throws Exception {
        Company company = dao.getCompany(5);
        System.out.println(company.getName());
    }
}