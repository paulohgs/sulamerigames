package com.smd.sulamerigames.client;

import com.smd.sulamerigames.interfaces.User;

public class Client implements User {

    String name;
    ClientDAO dao = new ClientDAO();

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void getAllUsers() {

    }
}
