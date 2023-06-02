package com.smd.sulamerigames;

import java.io.*;
import java.sql.SQLException;

import com.smd.sulamerigames.client.Client;
import com.smd.sulamerigames.client.ClientDAO;
import jakarta.servlet.http.*;

public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Client cliente = new Client("Teste", "1234", "teste", "teste, 1", "teste@teste.com");
        try {
            boolean result = ClientDAO.insert(cliente);
            if(result) {
                System.out.println("Usuário cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao realizar cadastro");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}