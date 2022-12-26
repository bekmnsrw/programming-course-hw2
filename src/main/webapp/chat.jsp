<%@ page import="java.util.List" %>
<%@ page import="static java.util.Objects.nonNull" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat: <%=request.getParameter("id")%></title>
</head>
<body>
    <form action="/chat" method="POST">
        <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
        <input type="text" name="message" placeholder="Enter Message">
        <button type="submit">Send</button>
    </form>
    <form action="/chat" method="POST">
        <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
        <input type="hidden" name="message">
        <button type="submit">Refresh chat history</button>
    </form>
    <a href="login.jsp"><input type="button" value="Back"></a>
    <h1 style="font-size:20px">"<%=request.getParameter("id")%>" chat history:</h1>
    <% List<String> messages = (List<String>) request.getSession().getAttribute("chatHistory"); %>
    <%if (nonNull(messages)) {%>
        <% for (String message : messages) { %>
            <%=message%>
            <br>
        <%}%>
    <%}%>
</body>
</html>