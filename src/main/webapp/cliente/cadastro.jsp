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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <title>Sulamerigames - Cadastro</title>
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
                    <input class="form-control" type="text" name="nome" placeholder="Digite seu nome">
                </label>
            </div>
            <div class="mb">
                <label  class="form-label">
                    Endereço:
                    <br>
                    <input class="form-control" type="text" name="endereco" placeholder="Digite seu endereço">
                </label>
            </div>
            <div class="mb">
                <label  class="form-label">
                    Email:
                    <br>
                    <input class="form-control" type="text" name="email" placeholder="Digite seu email">
                </label>
            </div>
            <div class="mb">
                <label  class="form-label">
                    Login:
                    <br>
                    <input class="form-control" type="text" name="login" placeholder="Digite seu usuário de Login">
                </label>
            </div>
            <div class="mb">
                <label  class="form-label">
                    Senha:
                    <br>
                    <input class="form-control" type="password" name="senha" placeholder="Digite sua senha">
                </label>
            </div>
            <button type="submit" class="btn btn-dark">Cadastrar</button>
        </div>>
    </form>
    </body>
</html>
