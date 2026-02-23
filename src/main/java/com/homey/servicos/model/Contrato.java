package com.homey.servicos.model;

public class Contrato {

    private String cliente;
    private String fornecedor;
    private Servico servico;
    private double valor;
    private String dataInicio;
    private String dataFim;

    public Contrato() {
    }

    public Contrato(String cliente, String fornecedor, Servico servico, double valor, String dataInicio, String dataFim) {
        this.cliente = cliente;
        this.fornecedor = fornecedor;
        this.servico = servico;
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public String getCliente() {
        return cliente;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public Servico getServico() {
        return servico;
    }

    public double getValor() {
        return valor;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }
}
