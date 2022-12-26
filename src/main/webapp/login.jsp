<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1 style="font-size:20px">Enter chat ID you want to create or join!</h1>
    <form action="/chat" method="GET">
        <input type="text" name="username" placeholder="Enter Your Username">
        <br>
        <input type="text" name="id" placeholder="Enter Chat ID">
        <br>
        <br>
        <button type="submit">Connect</button>
    </form>
</body>
</html>