package com.homey.servicos.service;

import com.homey.servicos.model.Usuario;
import com.homey.servicos.repository.UsuarioRepository;

public class PerfilUsuarioService {

    private UsuarioRepository repository;

    public PerfilUsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void atualizarPerfil(Usuario usuario) {

        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }

        if (usuario.getNome() == null || usuario.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email inválido");
        }

        if (usuario.getTelefone() == null || usuario.getTelefone().isBlank()) {
            throw new IllegalArgumentException("Telefone inválido");
        }

        if (usuario.getCep() == null || usuario.getCep().isBlank()) {
            throw new IllegalArgumentException("CEP inválido");
        }

        if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
            throw new IllegalArgumentException("Senha inválida");
        }

        repository.salvar(usuario);
    }
}