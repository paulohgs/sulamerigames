package com.smd.sulamerigames.client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    static String driver = "org.postgresql.Driver";
    static String url = "jdbc:postgresql://localhost:5432/sulamerigames";
    static String user = System.getenv("USER_DATABASE");
    static String pswd = System.getenv("PASSWORD_DATABASE");
    static Connection conn;

    static public boolean insert(Client cliente) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO cliente (name, email, login, password, address) VALUES (?,?,?,?,?)");
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getLogin());
            ps.setString(4, cliente.getSenha());
            ps.setString(5, cliente.getEndereco());
            ps.execute();
            ps.close();
            conn.close();
            return true;
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return false;
    }

    static public boolean remove(Integer idClient) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM cliente WHERE id=?");
            ps.setInt(1, idClient);
            ps.execute();
            ps.close();
            conn.close();
            return true;
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return false;
    }

    static public boolean update(Client cliente) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = conn.prepareStatement("UPDATE cliente SET name=?, email=?, login=?, password=?, address=? WHERE id=?");
            ps.setString(1,cliente.getNome());
            ps.setString(2,cliente.getEmail());
            ps.setString(3,cliente.getLogin());
            ps.setString(4,cliente.getSenha());
            ps.setString(5,cliente.getEndereco());
            ps.setInt(6,cliente.getId());
            ps.execute();
            ps.close();
            conn.close();
            return true;
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return false;
    }

    static public List<Client> listAllUsers() {
        List<Client> result = new ArrayList<>();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM cliente");
            ResultSet set = ps.executeQuery();
            while(set.next()){
                String name = set.getString("name");
                String password = set.getString("password");
                String login = set.getString("login");
                String endereco = set.getString("address");
                String email = set.getString("email");
                Client cliente = new Client(name, password,login, endereco, email);
                result.add(cliente);
            }
            set.close();
            ps.close();
            conn.close();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return result;
    }

    static public Client getClient(String loginUsed) {
        Client cliente = new Client("","","","","");
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM cliente WHERE login LIKE ?");
            ps.setString(1, loginUsed);
            ps.execute();
            ResultSet set = ps.getResultSet();
            while(set.next()){
                cliente.setId(set.getInt("id"));
                cliente.setEmail(set.getString("email"));
                cliente.setNome(set.getString("name"));
                cliente.setLogin(set.getString("login"));
                cliente.setSenha(set.getString("password"));
                cliente.setEndereco(set.getString("address"));
            }
            set.close();
            ps.close();
            conn.close();
            return cliente;
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return null;
    }

    static public boolean validLogin(String login, String password) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM cliente WHERE login=? AND password=?");
            ps.setString(1,login);
            ps.setString(2,password);
            ps.close();
            conn.close();
            return true;
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return false;
    }
}
