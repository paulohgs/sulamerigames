package com.smd.sulamerigames.product;

import com.smd.sulamerigames.category.Category;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Product {
    protected Integer id;
    protected String nome;
    protected String description;
    protected BigDecimal preco;
    protected Integer quantidade;
    protected Category categoria;
    protected String imagem;

    public Product(String nome, String description, BigDecimal preco, Integer quantidade, Category categoria, String imagem) {
        this.nome = nome;
        this.description = description;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.imagem = imagem;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPreco() { return preco; }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Category getCategoria() {
        return categoria;
    }

    public void setCategoria(Category categoria) {
        this.categoria = categoria;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
