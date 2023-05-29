package com.smd.sulamerigames.interfaces;

import java.util.List;

public interface UserDAO {
    boolean insert(User user);
    boolean remove(Integer id);
    boolean update(User user);
    List<User> listAllUsers();
    User getClient(User user);
}
