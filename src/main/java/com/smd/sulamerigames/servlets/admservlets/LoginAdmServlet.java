package com.smd.sulamerigames.servlets.admservlets;

import com.smd.sulamerigames.admin.AdminDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginAdmServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        boolean result = AdminDAO.validLogin(login, senha);

        PrintWriter out = response.getWriter();
        if(login == null || senha == null || login.isEmpty() || senha.isEmpty()) {
            response.sendRedirect("login.jsp");
            out.println("Usuário não existe, ou estão vazios!");
        } else if(result) {
            request.getSession().setAttribute("cliente", result);
            response.sendRedirect("session.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}