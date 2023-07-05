package com.smd.sulamerigames.servlets.productsservlets;

import com.smd.sulamerigames.product.ProductDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String campo = request.getParameter("campo");
        String valor = request.getParameter("valor");
        Integer produtoId = Integer.parseInt(request.getParameter("produto_id"));

        boolean resultado = ProductDAO.updateProduct(produtoId, campo, valor);

        if(!resultado) {
            request.setAttribute("mensagem", "Erro ao atualizar produto.");
            response.sendRedirect("ListAllProducts");
        }
        request.setAttribute("mensagem", "Produto atualizado com sucesso.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListAllProducts");
        dispatcher.forward(request, response);
    }
}
