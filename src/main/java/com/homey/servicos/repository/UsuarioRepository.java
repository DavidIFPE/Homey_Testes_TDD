package com.homey.servicos.repository;

import com.homey.servicos.model.Usuario;

public interface UsuarioRepository {

    Usuario buscarPorEmail(String email);
    void salvar(Usuario usuario);
}