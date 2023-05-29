package com.smd.sulamerigames.admin;

import com.smd.sulamerigames.interfaces.User;
import com.smd.sulamerigames.interfaces.UserDAO;

import java.util.List;

public class AdminDAO implements UserDAO {

    @Override
    public boolean insert(User user) {
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
