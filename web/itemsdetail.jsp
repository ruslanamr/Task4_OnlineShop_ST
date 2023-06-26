<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Item" %>
<%@ page import="models.Brand" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item detail</title>
    <%@include file="sdn.jsp" %>
</head>
<body>
<%@include file="nav.jsp" %>
<br>
<div class="container col-4">
    <br>
    <div class="card bg-light">
        <div class="card-body">

            <% Item item = (Item) request.getAttribute("item");
                if (item != null) {
            %>
            <h1><%=item.getBrand_id().getBrand_name()%> <%=item.getName()%>
            </h1>
            <p><%=item.getDescription()%>
            </p>
            <h4>Цена: <%=item.getPrice()%>
            </h4>
            <h4>Страна производителя: <%=item.getBrand_id().getCountry_id().getCountry_name()%>
            </h4>
            <%
                }
            %>


        </div>
    </div>
    <br>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#updatemodal">
        Изменить
    </button>
    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deletemodal">
        Удалить
    </button>
    <!-- Modal -->
    <div class="modal fade" id="updatemodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="updateitem" method="post">
                    <div class="modal-header">
                        <h4 class="modal-title fs-5">Изменить продукт
                        </h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
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
                        <input type="hidden" name="id" value="<%=item.getId()%>" >
                        <label class="form-label">Наименование</label>
                        <input type="text" class="form-control" name="name" value="<%=item.getName()%>">
                        <label class="form-label">Описание</label>
                        <input type="text" class="form-control" name="desc" value="<%=item.getDescription()%>">
                        <label class="form-label">Цена</label>
                        <input type="number" class="form-control" name="price" value="<%=item.getPrice()%>">
                        <br>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Изменить продукт</button>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <div class="modal fade" id="deletemodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="deleteitem" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title fs-5" id="exampleModalLabel">Удаление продукта ID: <%=item.getId()%>
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="id" value=<%=item.getId()%>>
                        <h4>Вы уверены, что хотите удалить <%=item.getBrand_id().getBrand_name()%> <%=item.getName()%>?</h4>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger">Удалить</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


</div>
</body>
</html>
