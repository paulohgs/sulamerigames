package com.smd.sulamerigames.servlets.productsservlets;

import com.smd.sulamerigames.category.Category;
import com.smd.sulamerigames.category.CategoryDAO;
import com.smd.sulamerigames.product.Product;
import com.smd.sulamerigames.product.ProductDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;

public class RegisterProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        Integer quantidade = Integer.valueOf(request.getParameter("quantidade"));
        BigDecimal preco = new BigDecimal(request.getParameter("preco"));
        Integer categoriaId = Integer.valueOf(request.getParameter("categoria"));
        Category categoria = CategoryDAO.getCategory(categoriaId);
        Product produto = new Product(nome, descricao, preco, quantidade, categoria, "");

        boolean result = ProductDAO.insertProduct(produto);

        if (!result) {
            request.setAttribute("mensagem", "Erro ao cadastrar produto.");
            response.sendError(500);
        }
        request.setAttribute("mensagem", "Produto inserido com sucesso.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListAllProducts");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}