package com.smd.sulamerigames.admin;

import com.smd.sulamerigames.client.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO  {
    static String driver = "org.postgresql.Driver";
    static String url = "jdbc:postgresql://localhost:5432/sulamerigames";
    static String user = System.getenv("USER_DATABASE");
    static String pswd = System.getenv("PASSWORD_DATABASE");
    static Connection conn;

    static public boolean insert(Admin admin) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO admin (name, email, login, password, address) VALUES (?,?,?,?,?)");
            ps.setString(1, admin.getNome());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getLogin());
            ps.setString(4, admin.getSenha());
            ps.setString(5, admin.getEndereco());
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
            PreparedStatement ps = conn.prepareStatement("DELETE FROM admin WHERE id=?");
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

    static public boolean update(Admin admin) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = conn.prepareStatement("UPDATE admin SET name=?, email=?, login=?, password=?, address=? WHERE id=?");
            ps.setString(1,admin.getNome());
            ps.setString(2,admin.getEmail());
            ps.setString(3,admin.getLogin());
            ps.setString(4,admin.getSenha());
            ps.setString(5,admin.getEndereco());
            ps.setInt(6,admin.getId());
            ps.execute();
            ps.close();
            conn.close();
            return true;
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return false;
    }

    static public List<Admin> listAllAdminUsers() {
        List<Admin> result = new ArrayList<>();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM admin");
            ResultSet set = ps.executeQuery();
            while(set.next()){
                String name = set.getString("name");
                String password = set.getString("password");
                String login = set.getString("login");
                String endereco = set.getString("address");
                String email = set.getString("email");
                Admin admin = new Admin(name, password,login, endereco, email);
                result.add(admin);
            }
            set.close();
            ps.close();
            conn.close();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return result;
    }

    static public Admin getAdmin(String loginUsed) {
        Admin admin = new Admin("","","","","");
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM admin WHERE login LIKE ?");
            ps.setString(1, loginUsed);
            ps.execute();
            ResultSet set = ps.getResultSet();
            while(set.next()){
                admin.setId(set.getInt("id"));
                admin.setEmail(set.getString("email"));
                admin.setNome(set.getString("name"));
                admin.setLogin(set.getString("login"));
                admin.setSenha(set.getString("password"));
                admin.setEndereco(set.getString("address"));
            }
            set.close();
            ps.close();
            conn.close();
            return admin;
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return null;
    }
    static public boolean validLogin(String login, String password) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM admin WHERE login=? AND password=?");
            ps.setString(1,login);
            ps.setString(2,password);
            ps.execute();
            ps.close();
            conn.close();
            return true;
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return false;
    }
}
