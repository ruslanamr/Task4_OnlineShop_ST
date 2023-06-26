<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration</title>

    <%@include file="sdn.jsp" %>
</head>
<body>
<%@include file="nav.jsp" %>

<div class="container col-4 ">
    <h4 style="text-align: center"> Регистрация на сайте </h4>
    <form action="/reg" method="post">
        <div class="mb-3">
            <label class="form-label"> Имя </label>
            <input type="text" class="form-control" name="name">

            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label"> Email </label>
                <input type="email" class="form-control" id="exampleInputEmail1" name="email"
                       aria - describedby="emailHelp">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label"> Пароль </label>
                <input type="password" class="form-control" id="exampleInputPassword1" name="pass">

            </div>

            <button type="submit" class="btn btn-primary"> Регистрация</button>
        </div>
    </form>

</div>

</body>
</html>