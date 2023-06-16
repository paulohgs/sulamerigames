<%--
  Created by IntelliJ IDEA.
  User: paulohenriquegomesdasilva
  Date: 01/06/23
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
  </head>
  <body>
    <h1>Identificação do Usuário</h1>
    <form action="Login" method="post">
      <label>
        Usuário:<input type="text" name="login" placeholder="usuário">
      </label>
      <br>
      <label>
        Senha:<input type="password" name="senha" placeholder="senha">
      </label>
      <br>
      <input type="submit" value="Entrar">
    </form>
  </body>
</html>