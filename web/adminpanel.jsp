<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Item" %>
<%@ page import="models.Country" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
    <%@include file="sdn.jsp" %>
</head>
<body>
<%@include file="navadmin.jsp" %>
<br>
<div class="container" style="text-align: right">

    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addbrand">
        Добавить Бренд
    </button>

    <a class="btn btn-success  " href="/addItem">Добавить товар</a>
    <!-- Button trigger modal -->




    <br>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>BRAND NAME</th>
            <th>NAME</th>
            <th>DESCRIPTION</th>
            <th>BRAND COUNTRY</th>
            <th>PRICE</th>
            <th>DETAILS</th>
        </tr>
        </thead>
        <tbody>



        <% ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("items");

            if (items != null) {
                for (Item it : items) {
        %>
            <tr>

                <td><%=it.getId()%></td>
                <td><%=it.getBrand_id().getBrand_name()%></td>
                <td><%=it.getName()%></td>
                <td><%=it.getDescription()%></td>
                <td><%=it.getBrand_id().getCountry_id().getCountry_name()%></td>
                <td><%=it.getPrice()%></td>
                <td>
                <a href="itemsdetail?id=<%=it.getId()%>" class="btn btn-dark btn-sm">Details</a>
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

<!-- Modal -->
<div class="modal fade" id="addbrand" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="addbrand" method="post">
                <div class="modal-header">
                    <h4 class="modal-title fs-5" id="exampleModalLabel">Добавление бренда
                    </h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <label> Название бренда </label>
                    <input type="text" name="name" class="form-control">
                    <label> Страна производителя бренда: </label>
                    <select name="country_id" class="form-select">
                        <%
                            ArrayList<Country> countries = (ArrayList<Country>) request.getAttribute("countries");
                            for (Country c : countries) { %>
                        <option value="<%=c.getId()%>"><%=c.getCountry_name()%>
                        </option>
                        <%
                            }
                        %>
                    </select>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Добавить бренд</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
