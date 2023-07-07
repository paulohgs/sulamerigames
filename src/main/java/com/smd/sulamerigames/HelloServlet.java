package com.smd.sulamerigames;

import java.io.*;
import java.sql.SQLException;

import com.smd.sulamerigames.client.Client;
import com.smd.sulamerigames.client.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class HelloServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Part filepart = request.getPart("imagem");
        String fileName = filepart.getSubmittedFileName();
        for (Part part : request.getParts()) {
            part.write("/Users/paulohenriquegomesdasilva/dev/ufc/sulamerigames/src/main/webapp/images/" + fileName);
        }
        response.sendRedirect("index.jsp");
    }

    public void destroy() {
    }
}