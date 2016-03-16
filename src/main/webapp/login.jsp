<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link href="css/style.css" rel='stylesheet' type='text/css'/>
</head>
<br>
<%--Registration form--%>
<form action="/logins" method="post">

    <br> User ID <input type="text" name="userId" required/>
    <div class="errorLabel">Номер контракта не найден.</div>
    <br> Password <input type="password" name="passwordId" required/>
    <br> <input type="submit" value="Submit"/>
</form>
<a href="/signup.jsp">Sign Up</a>


</body>
</html>
