package com.smd.sulamerigames.servlets.productsservlets;

import com.smd.sulamerigames.product.Product;
import com.smd.sulamerigames.product.ProductDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

public class ListAllProductsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> produtos = ProductDAO.getAllProducts();
        if(produtos.isEmpty()) {
            System.out.println("passou");
            request.setAttribute("mensagem", "Nenhum produto encontrado");
        }
        request.setAttribute("produtos", produtos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listProducts.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}