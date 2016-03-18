<%@ page import="com.expert.dto.Person" %>
<%@ page import="com.expert.dto.Company" %>
<%@ page import="com.expert.dto.Billing" %><%--
  Created by IntelliJ IDEA.
  User: DenisPenis
  Date: 16.03.2016
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h3>Login Successful!</h3>

<%
    Person person = (Person) session.getAttribute("person");
    Company company = (Company) session.getAttribute("company");
    Billing billing = (Billing) session.getAttribute("billing");

%>

<h1>Person:</h1>
<br>Full Name: <%=person.getFirstName()%> <%=person.getLastName()%>
<br>Phone: <%=person.getPhone()%>
<br>Email: <%=person.getEmail()%>

<br><h1>Company:</h1>
<br>Name: <%=company.getName()%>
<br>Office: <%=company.getOffice()%>
<br>City: <%=company.getCity()%>

<br><h1>Billing:</h1>
<br>Bank details: <%=billing.getBankDetails()%>
<br>Method: <%=billing.getMethod()%>

</body>
</html>
