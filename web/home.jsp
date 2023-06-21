<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <%@include file="sdn.jsp" %>
</head>
<body>
<%@include file="nav.jsp" %>
<div class="container" style="text-align: center">
    <h1>Добро пожаловать в E-SHOP</h1>
    <h4>Магазин электроники</h4>
    <br>

    <div class="row">
        <% ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("items");

            if (items != null) {
                for (Item it : items) {
        %>
        <div class="col-sm-3">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title"><%=it.getName()%></h5>
                </div>
                <div class="card-body" style="height: 150px;">
                    <h4 class="card-title" style="color: #0a58ca  "> <%=it.getPrice()%></h4>
                    <p class="card-text"><%=it.getDescription()%></p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary col-12">Купить сейчас</a>
                </div>
            </div>
            <br>
        </div>

        <%
                }
            }
        %>

    </div>


</div>
</body>
</html>
