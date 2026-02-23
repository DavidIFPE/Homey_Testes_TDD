package com.homey.servicos.service;

import com.homey.servicos.model.Categoria;
import com.homey.servicos.repository.CategoriaRepository;
import java.time.LocalDate;

public class CategoriaService {

    private CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public void criarCategoria(Categoria categoria) {

        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não pode ser nula");
        }

        if (categoria.getNome() == null || categoria.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome da categoria inválido");
        }

        // atribui data de criação se não informado
        if (categoria.getDataCriacao() == null || categoria.getDataCriacao().isBlank()) {
            categoria.setDataCriacao(LocalDate.now().toString());
        }

        repository.salvar(categoria);
    }
}
