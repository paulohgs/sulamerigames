package com.smd.sulamerigames.product;

import com.smd.sulamerigames.category.Category;
import com.smd.sulamerigames.category.CategoryDAO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    static String driver = "org.postgresql.Driver";
    static String url = "jdbc:postgresql://localhost:5432/sulamerigames";
    static String user = System.getenv("USER_DATABASE");
    static String pswd = System.getenv("PASSWORD_DATABASE");
    static Connection conn;

    static public Boolean insertProduct(Product produto) {

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO produto (preco, quantity, description, categoria_id, nome) VALUES (?, ?, ?, ?, ?)");
            ps.setBigDecimal(1, produto.preco);
            ps.setInt(2,produto.getQuantidade());
            ps.setString(3, produto.getDescription());
            ps.setInt(4, produto.categoria.getId());
            ps.setString(5,produto.getNome());
            ps.execute();
            ps.close();
            conn.close();
            return true;
        } catch(SQLException | ClassNotFoundException error) {
            error.printStackTrace(System.err);
        }
        return false;
    }

    static public Boolean removeProduct(Integer id) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pswd);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM produto WHERE id=?");
            ps.setInt(1,id);
            ps.execute();
            conn.close();
        } catch (SQLException | ClassNotFoundException error) {
            error.printStackTrace(System.err);
        }
        return false;
    }

    static public List<Product> getAllProducts() {
        List<Product> produtos = new ArrayList<Product>();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pswd);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM produto");
            ResultSet set  = ps.executeQuery();
            while(set.next()) {
                Integer id = set.getInt("id");
                BigDecimal preco = set.getBigDecimal("preco");
                String descricao = set.getString("description");
                Integer quantidade = set.getInt("quantity");
                Integer categoria_id = set.getInt("categoria_id");
                String nome = set.getString("nome");
                Category categoria = CategoryDAO.getCategory(categoria_id);
                Product produto = new Product(id,nome,descricao,preco,quantidade,categoria);
                produtos.add(produto);
            }
            set.close();
            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException error) {
            error.printStackTrace(System.err);
        }
        return produtos;
    }

    static public Boolean updateProduct(Product produto) {
        return false;
    }
}
