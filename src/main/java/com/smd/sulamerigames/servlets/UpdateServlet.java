package com.smd.sulamerigames.servlets;

import com.smd.sulamerigames.client.Client;
import com.smd.sulamerigames.client.ClientDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String opcao = request.getParameter("opcao");
        String updatedValue = request.getParameter("valorAtualizado");

        boolean result = ClientDAO.validLogin(login, senha);

        PrintWriter out = response.getWriter();
        if(login == null || senha == null || login.isEmpty() || senha.isEmpty()) {
            response.sendRedirect("login.jsp");
            out.println("Usuário não existe, ou estão vazios!");
        } else if(result) {
            Client cliente = ClientDAO.getClient(login);
            assert cliente != null;
            switch (opcao){
                case "nome":
                    cliente.setNome(updatedValue);
                    break;
                case "senha":
                    cliente.setSenha(updatedValue);
                    break;
                case "email":
                    cliente.setEmail(updatedValue);
                    break;
                case "endereco":
                    cliente.setEndereco(updatedValue);
                    break;
                case "login":
                    cliente.setLogin(updatedValue);
                default:
                    break;
            }
            boolean isUpdated = ClientDAO.update(cliente);
            if(isUpdated) {
                Client updatedClient = ClientDAO.getClient(login);
                request.getSession().setAttribute("cliente", updatedClient);
                response.sendRedirect("session.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}