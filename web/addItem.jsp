<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Brand" %>
<%@ page import="models.Country" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Item</title>

    <%@include file="sdn.jsp" %>
</head>
<body>
<%@include file="nav.jsp" %>

<div class="container col-4 ">
    <h4 style="text-align: center"> Добавление товара </h4>
    <form action="/addItem" method="post">
        <label class="form-label">Бренд</label> <br>
        <select class="form-select" name="brand">

            <%
                ArrayList<Brand> brands = (ArrayList<Brand>) request.getAttribute("brands");
                for (Brand br : brands) {%>
            <option value="<%=br.getId()%>"><%=br.getBrand_name()%>
            </option>
            <%
                }
            %>
        </select>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-light btn-sm" data-bs-toggle="modal" data-bs-target="#addbrand">
            Добавить Бренд
        </button>
        <br>

        <label class="form-label">Наименование</label>
        <input type="text" class="form-control" name="name">
        <label class="form-label">Описание</label>
        <input type="text" class="form-control" name="desc">
        <label class="form-label">Цена</label>
        <input type="number" class="form-control" name="price">
        <br>

    <br>
        <button type="submit" class="btn btn-primary">Добавить товар</button>

</form>


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
</div>

</body>
</html>
