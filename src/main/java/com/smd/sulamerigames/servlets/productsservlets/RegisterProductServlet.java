package com.smd.sulamerigames.servlets.productsservlets;

import com.smd.sulamerigames.category.Category;
import com.smd.sulamerigames.category.CategoryDAO;
import com.smd.sulamerigames.product.Product;
import com.smd.sulamerigames.product.ProductDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RegisterProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filepart = request.getPart("imagem");
        String filename = filepart.getSubmittedFileName();
        String path = "";
        for(Part part : request.getParts()) {
            path = "/Users/paulohenriquegomesdasilva/dev/ufc/sulamerigames/src/main/webapp/images/" + filename;
            part.write(path);
        }
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        Integer quantidade = Integer.valueOf(request.getParameter("quantidade"));
        BigDecimal preco = new BigDecimal(request.getParameter("preco"));
        Integer categoriaId = Integer.parseInt(request.getParameter("categoria"));
        Category categoria = CategoryDAO.getCategoryById(categoriaId);
        Product produto = new Product(nome, descricao, preco, quantidade, categoria, path);
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