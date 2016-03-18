<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link href="css/style.css" rel='stylesheet' type='text/css'/>
    <link href="css/login.css" rel='stylesheet' type='text/css'/>
</head>

<body>

    <div id="container">
        <form id="main" action="/login" method="post">

            <h1>LOGIN</h1>

            <input id="email" class="enter" type="text" name="email" placeholder="email" required/>

            <div class="errorLabel">Номер контракта не найден.</div>

            <input id="password" class="enter" type="password" name="passwordId" placeholder="password" required>


            <br> <input id="btn_in" type="submit" value="Log In"/>

            <br>

        </form>
        <form action="signup.jsp">
            <input id="btn_up" type="submit" value="Log Up">
        </form>


    </div>
</body>
</html>
