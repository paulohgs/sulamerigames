package com.smd.sulamerigames.servlets.admservlets;

import com.smd.sulamerigames.admin.Admin;
import com.smd.sulamerigames.admin.AdminDAO;
import com.smd.sulamerigames.category.CategoryDAO;
import com.smd.sulamerigames.product.ProductDAO;
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

        if(login == null || senha == null || login.isEmpty() || senha.isEmpty()) {
            request.setAttribute("mensagem", "Administrador não encontrado.");
            response.sendRedirect("adm/loginAdm.jsp");
        }
        Admin adm = AdminDAO.getAdmin(login);
        request.setAttribute("mensagem", "Administrador logado com sucesso.");
        request.getSession().setAttribute("adm", adm);
        request.getSession().setAttribute("categorias", CategoryDAO.getAllCategories());
        request.getSession().setAttribute("produtos", ProductDAO.getAllProducts());
        RequestDispatcher dispatcher = request.getRequestDispatcher("adm/principal.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}