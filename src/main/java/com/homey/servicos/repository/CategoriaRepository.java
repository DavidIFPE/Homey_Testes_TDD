package com.homey.servicos.repository;

import com.homey.servicos.model.Categoria;

/**
 * Repositório de Categoria (interface apenas - assinaturas para uso com Mockito)
 */
public interface CategoriaRepository {

    void salvar(Categoria categoria);

}
