package com.smd.sulamerigames.category;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

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

    static public List<Category> getAllCategories() {
        List<Category> categorias = new ArrayList<>();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pswd);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM categoria");
            ResultSet set = ps.executeQuery();
            while(set.next()) {
                Integer id = set.getInt("id");
                String descricao = set.getString("description");
                Category categoria = new Category(id,descricao);
                categorias.add(categoria);
            }
            set.close();
            ps.close();
            conn.close();
        } catch(SQLException | ClassNotFoundException error) {
            error.printStackTrace(System.err);
        }
        return categorias;
    }

    static public Boolean update(Integer id, String valor) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pswd);
            PreparedStatement ps = conn.prepareStatement("UPDATE categoria set description = ? WHERE id=?");
            ps.setString(1, valor);
            ps.setInt(2, id);
            ps.execute();
            ps.close();
            conn.close();
            return true;
        } catch (SQLException | ClassNotFoundException error){
            error.printStackTrace(System.err);
        }
        return false;
    }

    static public Boolean remove(Integer id) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pswd);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM categoria WHERE id=?");
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            conn.close();
            return true;
        } catch(SQLException | ClassNotFoundException error) {
            error.printStackTrace(System.err);
        }
        return false;
    }
}
