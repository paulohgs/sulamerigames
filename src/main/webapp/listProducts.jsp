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
    <script type="text/javascript">
        let mensagem = "<%=(String) request.getAttribute("mensagem")%>";
        console.log(mensagem)
        function showMessage() {
            if (mensagem !== "") {
                alert(mensagem)
            }
        }
    </script>
</head>
<body onload="showMessage()">

<%

    List<Product> produtos = (List<Product>) request.getAttribute("produtos");
    if(!produtos.isEmpty() || produtos != null) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
%>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Descrição</th>
        <th scope="col">Quantidade</th>
        <th scope="col">Preço</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <%
        for (int i = 0; i < produtos.size(); i++) {
            Product produto = produtos.get(i);
    %>
    <tr>
        <th scope="row"><%= i + 1 %></th>
        <td><%= produto.getDescription() %></td>
        <td><%= produto.getQuantidade() %></td>
        <td><%= decimalFormat.format(produto.getPreco()) %></td>
        <td><a class="btn btn-primary" href="#" role="button">Alterar</a></td>
        <td><a class="btn btn-danger" href="#" role="button">Excluir</a></td>
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
