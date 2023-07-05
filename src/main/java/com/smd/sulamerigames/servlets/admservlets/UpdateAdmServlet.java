package com.smd.sulamerigames.servlets.admservlets;

import com.smd.sulamerigames.admin.AdminDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UpdateAdmServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String campo = request.getParameter("campo");
        String valor = request.getParameter("valor");
        Integer admId = Integer.parseInt(request.getParameter("adm_id"));

        boolean resultado = AdminDAO.update(admId, campo, valor);

        if(!resultado) {
            request.setAttribute("mensagem", "Erro ao atualizar administrador");
            response.sendRedirect("adm/loginAdm.jsp");
        }
        request.setAttribute("mensagem", "Atualização realizada com sucesso!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("LoginAdmServlet");
        dispatcher.forward(request, response);
    }
}
