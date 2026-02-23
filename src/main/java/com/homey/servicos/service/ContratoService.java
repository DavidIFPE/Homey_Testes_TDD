/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.homey.servicos.service;

import com.homey.servicos.model.Contrato;
import com.homey.servicos.repository.ContratoRepository;

/**
 * Serviço para operações com contratos
 */
public class ContratoService {

    private ContratoRepository repository;

    public ContratoService(ContratoRepository repository) {
        this.repository = repository;
    }

    public void criarContrato(Contrato contrato) {

        if (contrato == null) {
            throw new IllegalArgumentException("Contrato não pode ser nulo");
        }

        if (contrato.getCliente() == null || contrato.getCliente().isBlank()) {
            throw new IllegalArgumentException("Cliente inválido");
        }

        if (contrato.getFornecedor() == null || contrato.getFornecedor().isBlank()) {
            throw new IllegalArgumentException("Fornecedor inválido");
        }

        if (contrato.getServico() == null) {
            throw new IllegalArgumentException("Serviço inválido");
        }

        if (contrato.getValor() <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        repository.salvar(contrato);
    }
}
