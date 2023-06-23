package com.smd.sulamerigames.servlets.clienteservlets;

import com.smd.sulamerigames.client.Client;
import com.smd.sulamerigames.client.ClientDAO;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        boolean result = ClientDAO.validLogin(login, senha);

        PrintWriter out = response.getWriter();
        if(login == null || senha == null || login.isEmpty() || senha.isEmpty()) {
            response.sendRedirect("cliente/login.jsp");
            out.println("Usuário não existe, ou estão vazios!");
        } else if(result) {
            Client cliente = ClientDAO.getClient(login);
            request.getSession().setAttribute("cliente", cliente);
            response.sendRedirect("session.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}