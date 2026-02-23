/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.homey.servicos.service;

/**
 *
 * @author GPADS
 */
import com.homey.servicos.model.Servico;
import com.homey.servicos.repository.ServicoRepository;
import java.util.List;

public class BuscaService {

    private ServicoRepository repository;

    public BuscaService(ServicoRepository repository) {
        this.repository = repository;
    }

    public List<Servico> buscar(String palavraChave) {

        if (palavraChave == null || palavraChave.isBlank()) {
            throw new IllegalArgumentException("Palavra-chave obrigatória");
        }

        return repository.buscarPorPalavraChave(palavraChave);
    }

    // NOVO MÉTODO COM FILTROS
    public List<Servico> buscarComFiltros(
            String palavraChave,
            double notaMinima,
            double distanciaMaxima,
            double precoMaximo) {

        if (palavraChave == null || palavraChave.isBlank()) {
            throw new IllegalArgumentException("Palavra-chave obrigatória");
        }

        if (notaMinima < 0 || notaMinima > 5) {
            throw new IllegalArgumentException("Nota inválida");
        }

        if (distanciaMaxima < 0) {
            throw new IllegalArgumentException("Distância inválida");
        }

        if (precoMaximo < 0) {
            throw new IllegalArgumentException("Preço inválido");
        }

        return repository.buscarPorPalavraChave(palavraChave);
    }
}
