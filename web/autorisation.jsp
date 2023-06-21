<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>autorisation</title>
    <%@include file="sdn.jsp" %>
</head>
<body>
<%@include file="nav.jsp" %>
<br>

<div class="container col-4 ">
    <h4 style="text-align: center">Авторизация на сайте </h4>
    <form action="/autorisation" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email</label>
            <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Пароль</label>
            <input type="password" class="form-control" id="exampleInputPassword1" name="pass" >
        </div>
        <button type="submit" class="btn btn-primary">Авторизоваться</button>
    </form>
</div>

</body>
</html>
