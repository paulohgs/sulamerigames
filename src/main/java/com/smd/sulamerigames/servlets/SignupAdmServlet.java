package com.smd.sulamerigames.servlets;

import com.smd.sulamerigames.admin.Admin;
import com.smd.sulamerigames.admin.AdminDAO;
import com.smd.sulamerigames.client.Client;
import com.smd.sulamerigames.client.ClientDAO;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class SignupAdmServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        Admin admin = new Admin(nome,senha,login,endereco,email);

        boolean result = AdminDAO.insert(admin);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (result) {
                out.println("<h1>Usuário " + nome+ " cadastrado com sucesso!</h1>");
                out.println("<a href='login.jsp'>Fazer Login</a>");
            } else {
                out.println("<h1>Erro ao cadastrar, tente novamente!</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}