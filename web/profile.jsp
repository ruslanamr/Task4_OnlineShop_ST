<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="sdn.jsp" %>
</head>
<body>
<%@include file="nav.jsp" %>

<% String name = (String) request.getAttribute("name");%>

<h4> Привествуем Вас <%=name%></h4>


</body>
</html>
