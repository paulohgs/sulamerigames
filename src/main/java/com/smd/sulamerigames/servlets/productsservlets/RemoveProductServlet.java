package com.smd.sulamerigames.servlets.productsservlets;

import com.smd.sulamerigames.product.ProductDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

public class RemoveProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("produto_id"));
        boolean result = ProductDAO.remove(productId);
        if(result) {
            request.setAttribute("mensagem", "Produto removido com sucesso.");
        } else {
            request.setAttribute("mensagem", "Produto não removido. Um erro interno aconteceu");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListAllProducts");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}