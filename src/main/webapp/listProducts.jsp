<%@ page import="com.smd.sulamerigames.product.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.DecimalFormatSymbols" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: paulohenriquegomesdasilva
  Date: 22/06/23
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produtos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <script type="text/javascript">
        let mensagem = "<%=(String) request.getAttribute("mensagem")%>";
        function showMessage() {
            if (mensagem !== "null") {
                alert(mensagem)
            }
        }
    </script>
</head>
<body onload="showMessage()"><!DOCTYPE html>
<header>
    <div class="container-fluid">
        <div class="mb-3 mt-3">
            <nav class="navbar navbar-dark bg-dark" >
                <div class="navbar nav">
                    <a href="adm/principal.jsp"  style="color: white" class="nav-link">Sulamerigames</a>
                    <a href="CadastroProd.jsp"  style="color: white" class="nav-link">Cadastrar produto</a>
                    <a href=""  style="color: white" class="nav-link">Cadastrar Categoria</a>
                    <a href="${pageContext.request.contextPath}/ListAllProducts"  style="color: white" class="nav-link">Listar Produtos</a>
                </div>
            </nav>
        </div>
    </div>
</header>
<%
    HttpSession sessao = request.getSession();
    List<Product> produtos = (List<Product>) sessao.getAttribute("produtos");
    if(!produtos.isEmpty() || produtos != null) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
%>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Nome</th>
        <th scope="col">Descrição</th>
        <th scope="col">Quantidade</th>
        <th scope="col">Preço</th>
        <th scope="col">Categoria</th>
        <th scope="col">Atualizar</th>
        <th scope="col">Exclusão</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (int i = 0; i < produtos.size(); i++) {
            Product produto = produtos.get(i);
    %>
    <tr>
        <th scope="row"><%= i + 1 %></th>
        <td><%= produto.getNome()%></td>
        <td><%= produto.getDescription() %></td>
        <td><%= produto.getQuantidade() %></td>
        <td><%= decimalFormat.format(produto.getPreco()) %></td>
        <td><%= produto.getCategoria().getDescricao()%></td>
        <td><a class="btn btn-dark" href="adm/alterarProduto.jsp?produto_id=<%=produto.getId()%>" role="button">Alterar</a></td>
        <td><a class="btn btn-danger" href="${pageContext.request.contextPath}/RemoveProduct?produto_id=<%=produto.getId()%>" role="button">Excluir</a></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
    }
%>
</body>
</html>
