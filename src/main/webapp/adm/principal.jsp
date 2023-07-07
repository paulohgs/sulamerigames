<%@ page import="com.smd.sulamerigames.admin.Admin" %><%--
  Created by IntelliJ IDEA.
  User: paulohenriquegomesdasilva
  Date: 07/07/23
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="resources/style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <title>Sulamerigames - Sua melhor loja de jogos latina!</title>
</head>
<body>
<%
    HttpSession sessao = request.getSession();
    Admin adm = (Admin) sessao.getAttribute("adm");
%>
<header>
    <div class="container-fluid">
        <div class="mb-3 mt-3">
            <nav class="navbar navbar-dark bg-dark" >
                <div class="navbar nav">
                    <a href="principal.jsp"  style="color: white" class="nav-link">Sulamerigames</a>
                    <a href="../CadastroProd.jsp"  style="color: white" class="nav-link">Cadastrar produto</a>
                    <a href=""  style="color: white" class="nav-link">Cadastrar Categoria</a>
                    <a href="${pageContext.request.contextPath}/ListAllProducts"  style="color: white" class="nav-link">Listar Produtos</a>
                </div>
            </nav>
        </div>
    </div>
</header>
<main>
    <h3>Bem vindo, ao sistema <%=adm.getNome()%></h3>
</main>
</body>
</html>

