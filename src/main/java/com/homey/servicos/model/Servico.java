/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.homey.servicos.model;

/**
 *
 * @author GPADS
 */
public class Servico {

    private String nome;
    private String categoria;
    private double preco;
    private double nota;
    private double distancia;

    public Servico() {
    }

    public Servico(String nome, String categoria, double preco, double nota, double distancia) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.nota = nota;
        this.distancia = distancia;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public double getNota() {
        return nota;
    }

    public double getDistancia() {
        return distancia;
    }
}
