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
</head>
<body>
<%
  HttpSession sessao = request.getSession();
  Client cliente = (Client) sessao.getAttribute("cliente");
  if(cliente != null){
    response.getWriter().println("<h1>Seja bem-vindo ao sistema, " + cliente.getNome() + "</h1>");
  } else {
    response.getWriter().println("<h1>Usuário nulo</h1>");
  }
%>
<a href="Cliente/update.jsp">Alterar dados</a>
<a href="Cliente/loggout.jsp">Sair</a>
</body>
</html>