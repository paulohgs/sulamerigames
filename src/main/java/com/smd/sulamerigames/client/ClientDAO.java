package com.smd.sulamerigames.client;

import com.smd.sulamerigames.interfaces.User;
import com.smd.sulamerigames.interfaces.UserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class ClientDAO implements UserDAO {

    Connection conn;

    public ClientDAO() {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/sulamerigames";
        String user = System.getenv("USER_DATABASE");
        String pswd = System.getenv("PASSWORD_DATABASE");
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url,user,pswd);
        } catch(Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public boolean insert(User cliente) {
        return false;
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public List<User> listAllUsers() {
        return null;
    }

    @Override
    public User getClient(User user) {
        return null;
    }
}
