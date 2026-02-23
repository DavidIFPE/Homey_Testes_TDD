package com.homey.servicos.model;

public class Categoria {
    private Long id;
    private String nome;
    
    protected String dataCriacao;

    public Categoria() {
    }
    
    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }
}