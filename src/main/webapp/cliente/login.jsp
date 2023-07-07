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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="src/main/webapp/resources/style.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <title>Login</title>
    <style>
      .navbar-custom .navbar-nav .nav-link {
        color: white;
      }
    </style>
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
    <main>
      <div class="container">
        <form action="${pageContext.request.contextPath}/Login" method="post">
          <div class="container-fluid">
            <div class="mb-3 mt-3">
              <label  class="form-label">
                Login:
                <br>
                <input class="form-control" type="text" name="login" placeholder="Digite seu nome de usuário">
              </label>
            </div>
            <div class="mb">
              <label class="form-label" for="inputPassword5">
                Senha: <input class="form-control" id="inputPassword5" type="password" name="senha" placeholder="Digite sua senha">
              </label>
            </div>
            <button type="submit" class="btn btn-dark">Entrar</button>
            <p>Não possui uma conta? Faça o seu cadastro <a href="cadastro.jsp">aqui</a>!</p>
          </div>
        </form>
      </div>
    </main>
  </body>
</html>