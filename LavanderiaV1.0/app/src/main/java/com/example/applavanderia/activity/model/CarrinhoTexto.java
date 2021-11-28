package com.example.applavanderia.activity.model;

public class CarrinhoTexto {
    private String tituloCarrinho;
    private String descricaoCarrinho;
    private String precoCarrinho;
    private String precoTaxaEntrega;

    public CarrinhoTexto() {}

    public CarrinhoTexto(String tituloCarrinho, String descricaoCarrinho, String precoCarrinho) {
        this.tituloCarrinho = tituloCarrinho;
        this.descricaoCarrinho = descricaoCarrinho;
        this.precoCarrinho = precoCarrinho;
    }

    public String getPrecoTaxaEntrega() {
        return precoTaxaEntrega;
    }

    public void setPrecoTaxaEntrega(String precoTaxaEntrega) {
        this.precoTaxaEntrega = precoTaxaEntrega;
    }

    public String getTituloCarrinho() {
        return tituloCarrinho;
    }

    public void setTituloCarrinho(String tituloCarrinho) {
        this.tituloCarrinho = tituloCarrinho;
    }

    public String getDescricaoCarrinho() {
        return descricaoCarrinho;
    }

    public void setDescricaoCarrinho(String descricaoCarrinho) {
        this.descricaoCarrinho = descricaoCarrinho;
    }

    public String getPrecoCarrinho() {
        return precoCarrinho;
    }

    public void setPrecoCarrinho(String precoCarrinho) {
        this.precoCarrinho = precoCarrinho;
    }
}
