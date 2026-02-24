package com.homey.servicos.service;

import com.homey.servicos.model.Usuario;
import com.homey.servicos.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario login(String email, String senha) {

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email inválido");
        }

        if (senha == null || senha.isBlank()) {
            throw new IllegalArgumentException("Senha inválida");
        }

        Usuario usuario = repository.buscarPorEmail(email);

        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        if (!usuario.getSenha().equals(senha)) {
            throw new IllegalArgumentException("Senha incorreta");
        }

        return usuario;
    }
}