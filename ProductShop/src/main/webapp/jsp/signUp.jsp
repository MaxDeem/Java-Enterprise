<%--
  Created by IntelliJ IDEA.
  User: КомпутерПогроммиста
  Date: 10.11.2018
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-6">
    <h1>${locale.get("signup.contact.us")}<a href="/signUp?lang=Ru">RU</a>|<a href="/signUp?lang=En">EN</a>|<a href="/signUp?lang=Po">Po</a> </h1>
    <form method="post">
        <input type="email" name="email" placeholder="${locale.get("signup.email")}" />
        <input type="password" name="password" placeholder="${locale.get("signup.password")}" />
        <input type="text" name="firstName" placeholder="${locale.get("signup.firstname")}" />
        <input type="text" name="lastName" placeholder="${locale.get("signup.lastname")}" />
        <input type="submit" value="${locale.get("signup.signup")}" />
    </form>
</div>
</body>
</html>
