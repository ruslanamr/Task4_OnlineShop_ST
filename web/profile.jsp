<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="sdn.jsp" %>
</head>
<body>
<%@include file="nav.jsp" %>

<% User user = (User) request.getAttribute("name");%>
<br>
<div class="container text-center">
<h2> Привествуем Вас <%=user.getFullName()%>!</h2>
    <h5>Это Ваша персональная страница</h5>
    <br><br>
    <h5>Ваш ID: <%=user.getId()%>,</h5>
    <h5>Ваш e-mail: <%=user.getEmail()%></h5>
</div>

</body>
</html>
