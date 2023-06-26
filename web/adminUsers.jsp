<%@ page import="java.util.ArrayList" %>
<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
    <%@include file="sdn.jsp" %>
</head>
<body>
<%@include file="navadmin.jsp" %>
<br>
<h3 style="text-align: center" > Список зарегестрированных пользователей
</h3>
<div class="container">
    <br>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>FULL NAME</th>
            <th>Email</th>
            <th>DETAILS</th>
        </tr>
        </thead>
        <tbody>


        <% ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");

            if (users != null) {
                for (User u : users) {
        %>
        <tr>

            <td><%=u.getId()%>
            </td>
            <td><%=u.getFullName()%>
            </td>
            <td><%=u.getEmail()%>
            </td>
            <td>
                <a href="userdetail?id=<%=u.getId()%>" class="btn btn-dark btn-sm">Details</a>
            </td>

        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
</div>

</div>

</div>
</body>
</html>
