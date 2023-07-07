<%@ page import="com.smd.sulamerigames.client.Client" %><%--
  Created by IntelliJ IDEA.
  User: paulohenriquegomesdasilva
  Date: 02/06/23
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sulamerigames - Atualizar Cadastro</title>
</head>
<body>
  <%
    HttpSession sessao = request.getSession();
    Client cliente = (Client) sessao.getAttribute("cliente");
  %>
  <form action="${pageContext.request.contextPath}/Update" method="post">
    <label>
      <input type="text" placeholder="Digite seu login">
    </label>
    <br>
    <label>
      <input type="password" placeholder="Digite sua senha">
    </label>
    <br>
    <label>Escolha o campo a ser alterado: </label>
    <select name="opcao">
      <option value="nome">Nome</option>
      <option value="senha">Senha</option>
      <option value="login">login</option>
      <option value="endereco">Endereço</option>
      <option value="email">Email</option>
    </select>
    <br>
    <label>
      <input type="text" name="valorAtualizado" placeholder="Valor atualizado">
    </label>
    <br>
    <label>
      <input type="submit">
    </label>
  </form>
</body>
</html>
