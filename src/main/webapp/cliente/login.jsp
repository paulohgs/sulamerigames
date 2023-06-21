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
    <title>Login</title>
  </head>
  <body>
    <header>
      <nav>
        <a href="../index.jsp">
          <h1>Loja de jogos</h1>
        </a>
      </nav>
    </header>
    <form action="Login" method="post">
      <label>Login:<input type="text" name="login" placeholder="Digite seu nome de usuário"></label>
      <br>
      <label>Senha:<input type="password" name="senha" placeholder="Digite sua senha"></label>
      <label><input type="submit" value="Entrar"></label>
      <p>Não possui uma conta? Faça o seu cadastro <a href="cadastro.jsp">aqui</a>!</p>
    </form>
  </body>
</html>