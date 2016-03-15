package com.expert.dao;

import com.expert.dto.Billing;
import com.expert.dto.Company;
import com.expert.dto.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dmytro on 13.03.16.
 */
public class NamedParametersDaoImpl extends NamedParameterJdbcDaoSupport {
    private final String PERSON_TABLE = "contact_details";
    private final String COMPANY_TABLE = "company_details";
    private final String BILLING_TABLE = "billing_details";

    public void addPerson(Person p){
        String sql = "insert into " + PERSON_TABLE +"(position, first_name, last_name," +
                "phone, email, skype, city, password)"+
                " values(" +
                ":position, :firstName, :lastName, :phone, " +
                ":email, :skype, :city, :password)";
        SqlParameterSource parameterSource =
                new MapSqlParameterSource("position",p.getPosition())
                .addValue("firstName", p.getFirstName())
                .addValue("lastName", p.getLastName())
                .addValue("phone", p.getPhone())
                .addValue("email", p.getEmail())
                .addValue("skype", p.getSkype())
                .addValue("city", p.getCity())
                .addValue("password", p.getPassword());
        getNamedParameterJdbcTemplate().update(sql, parameterSource);
    }
    public void addCompany(Company c){
        String sql = "insert into " + COMPANY_TABLE +"(name, office, fax," +
                "email, billing_address, city,contact_id)"+
                " values(" +
                ":name, :office, :fax, :email, " +
                ":billing_address, :city, :contact_id)";
        SqlParameterSource parameterSource =
                new MapSqlParameterSource("contact_id",c.getPersonId())
                        .addValue("name", c.getName())
                        .addValue("office", c.getOffice())
                        .addValue("fax", c.getFax())
                        .addValue("email", c.getEmail())
                        .addValue("billing_address", c.getBillingAddress())
                        .addValue("city", c.getCity());
        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    public void addBilling(Billing b){
        String sql = "insert into " + BILLING_TABLE +"(method, bank_details, credit_card," +
                "cvv, exp_data,contact_id)"+
                " values(" +
                ":method, :bank_details, :credit_card, :cvv, " +
                ":exp_data, :contact_id)";
        SqlParameterSource parameterSource =
                new MapSqlParameterSource("method",b.getMethod())
                        .addValue("bank_details", b.getBankDetails())
                        .addValue("credit_card", b.getCreditCard())
                        .addValue("cvv", b.getCvv())
                        .addValue("exp_data", b.getExpDate())
                        .addValue("contact_id", b.getUserId());
        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    public boolean isLogin(String email, String password){
        String sql = "select count(*) from " + PERSON_TABLE +
                " where email = :email and password = :password";
        SqlParameterSource parameterSource =
                new MapSqlParameterSource("email",email)
                        .addValue("password", password);
        int count = getNamedParameterJdbcTemplate().queryForObject(sql,parameterSource, Integer.class);
        if(count == 0)
            return false;
        return true;
    }

    public boolean isCompanyExist(String name){
        String sql = "select count(*) from " + COMPANY_TABLE +
                " where name = ?";
        int count = getJdbcTemplate().queryForObject(sql,new Object[]{name}, Integer.class);
        if(count == 0)
            return false;
        return true;
    }
    public boolean isBillingExist(String creditCard){
        String sql = "select count(*) from " + BILLING_TABLE +
                " where credit_card = ?";
        int count = getJdbcTemplate().queryForObject(sql,new Object[]{creditCard}, Integer.class);
        if(count == 0)
            return false;
        return true;
    }


    private final static class PersonMapper implements RowMapper<Person> {
        public Person mapRow(ResultSet rs, int i) throws SQLException {
            Person person = new Person(rs.getString("position"), rs.getString("first_name"),
                    rs.getString("last_name"),rs.getString("phone"),rs.getString("email"),
                    rs.getString("skype"), rs.getString("city"), rs.getString("password"));
            person.setId(rs.getInt("id"));
            return person;
        }
    }
    private final static class CompanyMapper implements RowMapper<Company> {
        public Company mapRow(ResultSet rs, int i) throws SQLException {
            Company company = new Company(rs.getInt("contact_id"), rs.getString("name"),
                    rs.getString("office"),rs.getString("fax"),rs.getString("email"),
                    rs.getString("billing_address"), rs.getString("city"));
            company.setId(rs.getInt("id"));
            return company;
        }
    }
    private final static class BillingMapper implements RowMapper<Billing> {
        public Billing mapRow(ResultSet rs, int i) throws SQLException {
            Billing billing = new Billing(rs.getInt("contact_id"), rs.getString("method"),
                    rs.getString("bank_details"),rs.getString("credit_card"),rs.getString("cvv"),
                    rs.getDate("exp_data"));
            billing.setId(rs.getInt("id"));
            return billing;
        }
    }



}
