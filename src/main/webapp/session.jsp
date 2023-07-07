<%--
  Created by IntelliJ IDEA.
  User: paulohenriquegomesdasilva
  Date: 02/06/23
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.smd.sulamerigames.client.Client"%>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Sessão</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
<header>
  <div class="container-fluid">
    <div class="mb-3 mt-3">
      <nav class="navbar navbar-dark bg-dark" >
        <div class="navbar nav">
          <a href="index.jsp"  style="color: white" class="nav-link">E-comerce</a>
          <a href="cliente/login.jsp"  style="color: white" class="nav-link">Login</a>
          <a href="#"  style="color: white" class="nav-link">Carrinho</a>
          <a href="#"  style="color: white" class="nav-link">Produtos</a>
        </div>
      </nav>
    </div>
  </div>
</header>
<%
  HttpSession sessao = request.getSession();
  Client cliente = (Client) sessao.getAttribute("cliente");
  if(cliente != null){
    response.getWriter().println("<h1>Seja bem-vindo ao sistema, " + cliente.getNome() + "</h1>");
  } else {
    response.getWriter().println("<h1>Usuário nulo</h1>");
  }
%>
<a href="cliente/update.jsp">Alterar dados</a>
<a href="cliente/loggout.jsp">Sair</a>
</body>
</html>