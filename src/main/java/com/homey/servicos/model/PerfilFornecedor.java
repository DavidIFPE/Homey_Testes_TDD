/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.homey.servicos.model;

/**
 *
 * @author GPADS
 */
public class PerfilFornecedor {

    private String categoria;
    private String descricao;
    private String precificacao;
    private double preco;

    public PerfilFornecedor() {
    }

    public PerfilFornecedor(String categoria, String descricao, String precificacao, double preco) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.precificacao = precificacao;
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrecificacao() {
        return precificacao;
    }

    public void setPrecificacao(String precificacao) {
        this.precificacao = precificacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
