/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.homey.servicos.service;

/**
 *
 * @author GPADS
 */
import com.homey.servicos.model.PerfilFornecedor;
import com.homey.servicos.repository.PerfilFornecedorRepository;
import java.util.List;

public class PerfilFornecedorService {

    private PerfilFornecedorRepository repository;

    // lista de precificações válidas
    private final List<String> precificacoesValidas =
            List.of("Diária", "Hora", "Projeto");

    public PerfilFornecedorService(PerfilFornecedorRepository repository) {
        this.repository = repository;
    }

    public void atualizarPerfil(PerfilFornecedor perfil) {

        if (perfil == null) {
            throw new IllegalArgumentException("Perfil não pode ser nulo");
        }

        if (perfil.getCategoria() == null || perfil.getCategoria().isBlank()) {
            throw new IllegalArgumentException("Categoria inválida");
        }

        if (perfil.getDescricao() == null || perfil.getDescricao().isBlank()) {
            throw new IllegalArgumentException("Descrição inválida");
        }

        if (perfil.getPrecificacao() == null ||
                !precificacoesValidas.contains(perfil.getPrecificacao())) {
            throw new IllegalArgumentException("Precificação inválida");
        }

        if (perfil.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço inválido");
        }

        repository.salvar(perfil);
    }
}

