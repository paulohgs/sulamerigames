package com.smd.sulamerigames.category;

import java.sql.*;

public class CategoryDAO {
    static String driver = "org.postgresql.Driver";
    static String url = "jdbc:postgresql://localhost:5432/sulamerigames";
    static String user = System.getenv("USER_DATABASE");
    static String pswd = System.getenv("PASSWORD_DATABASE");
    static Connection conn;

    static public Boolean insert(Category categoria) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pswd);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO categoria (description) VALUES (?)");
            ps.setString(1, categoria.descricao);
            ps.execute();
            ps.close();
            conn.close();
            return true;
        } catch (SQLException | ClassNotFoundException error) {
            error.printStackTrace(System.err);
        }
        return false;
    }

    static public Category getCategory(Integer id) {
        Category categoria = new Category(0,"");
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pswd);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM categoria WHERE id=?");
            ps.setInt(1,id);
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                categoria.id = set.getInt("id");
                categoria.descricao = set.getString("description");
            }
            set.close();
            ps.close();
            conn.close();
            return categoria;
        } catch (SQLException | ClassNotFoundException error) {
            error.printStackTrace(System.err);
        }
        return null;
    }
}
