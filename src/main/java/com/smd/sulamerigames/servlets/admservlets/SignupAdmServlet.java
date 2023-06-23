package com.smd.sulamerigames.servlets.admservlets;

import com.smd.sulamerigames.admin.Admin;
import com.smd.sulamerigames.admin.AdminDAO;
import com.smd.sulamerigames.client.Client;
import com.smd.sulamerigames.client.ClientDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class SignupAdmServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        Admin admin = new Admin(nome,senha,login,endereco,email);

        boolean result = AdminDAO.insert(admin);

        if (!result) {
            request.setAttribute("mensagem", "erro ao cadastrar admin.");
            response.sendRedirect("adm/cadastroAdm.jsp");
        }
        request.setAttribute("mensagem", "adm cadastrado com sucesso");
        request.getSession().setAttribute("adm", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("adm/loginAdm.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}