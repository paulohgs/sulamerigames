<%--
  Created by IntelliJ IDEA.
  User: guilh
  Date: 22/06/2023
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <title>Sulamerigames - Cadastro de Produto</title>
</head>
<body>
<header>
    <div class="container-fluid">
        <div class="mb-3 mt-3">
            <nav class="navbar navbar-dark bg-dark" >
                <div class="navbar nav">
                    <a class="nav-link" style="color: white" href="../index.jsp" >
                        Loja de jogos
                    </a>
                </div>
            </nav>
        </div>
    </div>
</header>
<form action="Signup" method="post">
    <div class="container-fluid">
        <div class="mb-3 mt-3">
            <label  class="form-label">
                Nome:
                <br>
                <input class="form-control" type="text" name="nome" placeholder="Digite o nome do produto">
            </label>
        </div>
        <div class="mb">
            <label  class="form-label">
                Preço:
                <br>
                <input class="form-control" type="number" name="preço" placeholder="Digite o valor">
            </label>
        </div>
        <div class="mb">
            <label  class="form-label">
                Descrição:
                <br>
                <input class="form-control" type="text" name="descrição" placeholder="Digite a descrição do produto">
            </label>
        </div>
        <div class="mb">
            <label  class="form-label">
                Quantidade:
                <br>
                <input class="form-control" type="number" name="quantidade" placeholder="Digite a quantidade de produtos">
            </label>
        </div>
        <div class="mb">
            <label  class="form-label">
                Categoria:
                <br>
                <input class="form-control" type="text" name="categoria" placeholder="Digite qual o produto">
            </label>
        </div>
        <div class="mb">
            <label  class="form-label">
                Coloque uma foto do produto
                <br>
                <input class="form-control-file" type="file" name="Imagem" >
            </label>
        </div>
        <button type="submit" class="btn btn-dark">Cadastrar</button>
    </div>>
</form>
</body>
</html>