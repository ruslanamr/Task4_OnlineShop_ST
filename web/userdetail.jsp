<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item detail</title>
    <%@include file="sdn.jsp" %>
</head>
<body>
<%@include file="navadmin.jsp" %>
<br>
<div class="container col-4">

    <br>
    <div class="card bg-light">
        <div class="card-body">

            <% User u = (User) request.getAttribute("user");
                if (u != null) {
            %>
            <h1><%=u.getFullName()%> ID: <%=u.getId()%>
            </h1>
            </p>
            <h4>E-mail: <%=u.getEmail()%>
            </h4>
            <%
                }
            %>


        </div>
    </div>
    <br>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editmodal">
        Изменить данные
    </button>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editpasmodal">
        Изменить пароль
    </button>
    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deletemodal">
        Удалить
    </button>

    <div class="modal fade" id="editmodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="edituser" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title fs-5">Редактирование пользователя ID: <%=u.getId()%>
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <input type="hidden" name="id" value=<%=u.getId()%>>
                        <label class="form-label"> Имя </label>
                        <input type="text" class="form-control" name="name" value="<%=u.getFullName()%>">

                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label"> Email </label>
                            <input type="email" class="form-control" id="exampleInputEmail1" name="email"
                                   aria - describedby="emailHelp" value="<%=u.getEmail()%>">
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label"> Текущий пароль </label>
                            <input type="password" class="form-control" name="pass">
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-success">Внести изменения</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="editpasmodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="editpassuser" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title fs-5">Изменение пароля пользователя ID: <%=u.getId()%>
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="id" value=<%=u.getId()%>>
                        <div class="mb-3">
                            <%--@declare id="exampleinputpassword1"--%>
                            <label for="exampleInputPassword1" class="form-label"> Текущий пароль </label>
                            <input type="password" class="form-control" name="pass">
                        </div>

                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label"> Новый пароль </label>
                            <input type="password" class="form-control" name="pass1">
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label"> Повторите новый пароль </label>
                            <input type="password" class="form-control" name="pass2">
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-success">Изменить пароль</button>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <div class="modal fade" id="deletemodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="deleteuser" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title fs-5" id="exampleModalLabel">Удаление пользователя ID: <%=u.getId()%>
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="id" value=<%=u.getId()%>>
                        <h4>Для удаления пользователя <%=u.getFullName()%> введите пароль: </h4>
                        <input type="password" class="form-control" name="pass">
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
</body>
</html>
