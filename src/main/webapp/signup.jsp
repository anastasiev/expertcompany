<%--
  Created by IntelliJ IDEA.
  User: DenisPenis
  Date: 14.03.2016
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link href="css/style.css" rel='stylesheet' type='text/css'/>
</head>
<body>

<div class="main">
    <form action="/signUp" method="post">
        <div class="lable">
            <ul class="left_ul">
                <li>
                    <div class="field"><input type="text" class="text" placeholder="Position" name="position" autofocus required>
                    </div>
                </li>
                <li>
                    <div class="field"><input type="text" class="text" placeholder="First Name" id="active"
                                              name="firstName" required></div>
                </li>
                <li>
                    <div class="field"><input type="text" class="text" placeholder="Last Name" name="lastName" required>
                    </div>
                </li>
                <li>
                    <div class="field"><input type="email" class="text" placeholder="Email" name="contactEmail"  required>
                    </div>
                </li>
                <li>
                    <div class="field"><input type="text" class="text" placeholder="City" name="contactCity" required>
                    </div>
                </li>
                <li>
                    <div class="field"><input type="text" class="text" placeholder="Skype" name="contactSkype" required>
                    </div>
                </li>
                <li>
                    <div class="field"><input type="password" class="text" placeholder="Password" name="password"
                                              required></div>
                </li>
            </ul>
            <ul class="center_ul">
                <li>
                    <div class="field"><input type="text" class="text" placeholder="Company name" name="companyName"
                                              required>
                    </div>
                </li>
                <li>
                    <div class="field"><input type="text" class="text" placeholder="Office" name="companyOffice"
                                              required></div>
                </li>
                <li>
                    <div class="field"><input type="text" class="text" placeholder="Fax" name="companyFax" required>
                    </div>
                </li>
                <li>

                    <div class="field"><input type="email" class="text" placeholder="Email" name="companyEmail" value="" <%--pattern="/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/"--%> required>
                    </div>
                </li>
                <li>
                    <div class="field"><input type="text" class="text" placeholder="Billing Address"
                                              name="companyBilling" required></div>
                </li>
                <li>
                    <div class="field"><input type="text" class="text" placeholder="City" name="companyCity" required>
                    </div>
                </li>
                <li class="button"><input type="submit" value="Create account"/></li>
            </ul>
            <ul class="right_ul">
                <li>
                    <div class="field"><input type="text" class="text" placeholder="Method" name="billingMethod"
                                              required></div>
                </li>
                <li>
                    <div class="field"><input type="text" class="text" placeholder="Bank Details" name="bankDetails"
                                              required>
                    </div>
                </li>
                <li>
                    <div class="field"><input type="number" class="text" placeholder="Credit Card" name="creditCard"
                                              pattern="[0-9]{16}" required>
                    </div>
                </li>
                <li>
                    <div class="field"><input type="text" class="text" placeholder="CVV" name="billingCvv" pattern="[0-9]{3}" required>
                    </div>
                </li>
                <li>
                    <div class="field"><input type="date" class="text" placeholder="Exp Date" name="expDate" required>
                    </div>
                </li>
            </ul>


            <%--<div class="clear"></div>--%>
        </div>
        <%--<div class="lable-2">--%>
        <%--<input type="text" class="text" value="your@email.com " onfocus="this.value = '';"--%>
        <%--onblur="if (this.value == '') {this.value = 'your@email.com ';}">--%>
        <%--<div class="col_1_of_2 span_1_of_2"><input type="text" class="text" value="Skype"--%>
        <%--name="contactSkype"></div>--%>
        <%--<input type="password" class="text" value="Password " onfocus="this.value = '';"--%>
        <%--onblur="if (this.value == '') {this.value = 'Password ';}">--%>
        <%--</div>--%>
        <%--<h3>By creating an account, you agree to our <span class="term"><a href="#">Terms & Conditions</a></span></h3>--%>
        <%--<div class="submit">--%>

        <%--</div>--%>
        <%--<div class="clear"></div>--%>
    </form>
</div>
</body>
</html>
