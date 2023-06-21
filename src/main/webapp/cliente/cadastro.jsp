<%--
  Created by IntelliJ IDEA.
  User: paulohenriquegomesdasilva
  Date: 01/06/23
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sulamerigames - Cadastro</title>
</head>
    <body>
    <form action="Signup" method="post">
        <label>
            Nome: <input type="text" name="nome">
        </label>
        <br>
        <label>
            Endereço:<input type="text" name="endereco">
        </label>
        <br>
        <label>
            E-mail:<input type="text" name="email">
        </label>
        <br>
        <label>
            Login:<input type="text" name="login">
        </label>
        <br>
        <label>
            Senha:<input type="password" name="senha">
        </label>
            <br>
        <input type="submit" value="Cadastrar">
    </form>
    </body>
</html>
