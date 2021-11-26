package com.example.applavanderia.activity.model;

public class LavagemCompleta {
    public String titulo;
    private String descricao;
    private String preco;


    public LavagemCompleta() {

    }

    public LavagemCompleta(String titulo, String descricao, String preco) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
