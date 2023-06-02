package com.smd.sulamerigames.admin;

public class Admin {

    private Integer id;
    private String nome;
    private String senha;
    private String login;
    private String endereco;
    private String email;

    public Admin(String nome, String senha, String login, String endereco, String email) {
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.endereco = endereco;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
