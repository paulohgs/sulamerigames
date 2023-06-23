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
            PreparedStatement ps = conn.prepareStatement("INSERT INTO produto (preco, quantity, description, categoria_id, nome, imagem) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setBigDecimal(1, produto.preco);
            ps.setInt(2,produto.getQuantidade());
            ps.setString(3, produto.getDescription());
            ps.setInt(4, produto.categoria.getId());
            ps.setString(5,produto.getNome());
            ps.setString(6, produto.getImagem());
            ps.execute();
            ps.close();
            conn.close();
            return true;
        } catch(SQLException | ClassNotFoundException error) {
            error.printStackTrace(System.err);
        }
        return false;
    }

    static public Boolean remove(Integer id) {
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
                String imagem = set.getString("imagem");
                Category categoria = CategoryDAO.getCategory(categoria_id);
                Product produto = new Product(nome,descricao,preco,quantidade,categoria, imagem);
                produto.setId(id);
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

    static public Product getProduct(Integer id) {
        Product produto = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pswd);
            PreparedStatement ps  = conn.prepareStatement("SELECT * FROM produto WHERE ID=?");
            ps.setInt(1, id);
            ResultSet set = ps.executeQuery();
            while(set.next()) {
                Integer produto_id = set.getInt("id");
                String nome = set.getString("nome");
                String imagem = set.getString("imagem");
                String descricao = set.getString("description");
                Integer quantidade = set.getInt("quantity");
                BigDecimal preco = set.getBigDecimal("preco");
                Integer categoria_id = set.getInt("categoria_id");
                produto.setImagem(imagem);
                produto.setDescription(descricao);
                produto.setId(produto_id);
                produto.setPreco(preco);
                produto.setNome(nome);
                produto.setQuantidade(quantidade);
                produto.setCategoria(CategoryDAO.getCategory(categoria_id));
            }
            set.close();
            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException error) {
            error.printStackTrace(System.err);
        }
        return produto;
    }

    static public Boolean updateProduct(Integer id, String campo, String valor) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pswd);
            PreparedStatement ps = conn.prepareStatement("UPDATE produto set ? = ? WHERE id=?");
            switch(campo) {
                case "descricao":
                    ps.setString(1, "description");
                    ps.setString(2, valor);
                    break;
                case "quantidade":
                    ps.setString(1,"quantity");
                    ps.setInt(1, Integer.parseInt(valor));
                    break;
                case "preco":
                    ps.setString(1,"preco");
                    ps.setBigDecimal(2, new BigDecimal(valor));
                    break;
                case "categoria":
                    ps.setString(1,"categoria_id");
                    ps.setInt(2, Integer.parseInt(valor));
                    break;
                case "nome":
                    ps.setString(1, "nome");
                    ps.setString(2, valor);
                    break;
                case "imagem":
                    ps.setString(1, "imagem");
                    ps.setString(2, valor);
                    break;
                default:
                    break;
            }
            ps.setInt(3, id);
            ps.execute();
            ps.close();
            conn.close();
            return true;
        } catch (SQLException | ClassNotFoundException error) {
            error.printStackTrace(System.err);
        }
        return false;
    }
}
