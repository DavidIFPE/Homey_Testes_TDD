package com.homey.servicos.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.homey.servicos.model.Usuario;
import com.homey.servicos.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    UsuarioRepository repository;

    @InjectMocks
    UsuarioService service;

    @InjectMocks
    PerfilUsuarioService perfilService;

    @Test
    void TC013_deveRealizarLoginComDadosValidos() {

        Usuario usuario = new Usuario(
                "Thamires",
                "thamiresfernandes",
                "81999999999",
                "50700000",
                "Thami@2912"
        );

        when(repository.buscarPorEmail("thamiresfernandes"))
                .thenReturn(usuario);

        Usuario resultado =
                service.login("thamiresfernandes", "Thami@2912");

        assertNotNull(resultado);

        verify(repository).buscarPorEmail("thamiresfernandes");
    }

    @Test
    void TC014_naoDeveLogarComSenhaInvalida() {

        Usuario usuario = new Usuario(
                "Thamires",
                "thamiresfernandes",
                "81999999999",
                "50700000",
                "Thami@2912"
        );

        when(repository.buscarPorEmail("thamiresfernandes"))
                .thenReturn(usuario);

        assertThrows(IllegalArgumentException.class, () -> {
            service.login("thamiresfernandes", "00000000");
        });

        verify(repository).buscarPorEmail("thamiresfernandes");
    }

    @Test
    void TC015_naoDeveLogarComEmailInvalido() {

        when(repository.buscarPorEmail("thamires@user"))
                .thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> {
            service.login("thamires@user", "Thami@2912");
        });

        verify(repository).buscarPorEmail("thamires@user");
    }

    @Test
    void TC018_deveRealizarLoginComCredenciaisValidas() {

        Usuario usuario = new Usuario(
                "João",
                "joao@email.com",
                "81999999999",
                "50700000",
                "123456"
        );

        when(repository.buscarPorEmail("joao@email.com"))
                .thenReturn(usuario);

        Usuario resultado = service.login("joao@email.com", "123456");

        assertNotNull(resultado);
        assertEquals("João", resultado.getNome());

        verify(repository).buscarPorEmail("joao@email.com");
    }

    @Test
    void TC019_deveAtualizarPerfilComDadosValidos() {

        Usuario usuario = new Usuario(
                "João",
                "joao@email.com",
                "81999999999",
                "50700000",
                "123456"
        );

        perfilService.atualizarPerfil(usuario);

        verify(repository).salvar(usuario);
    }

    @Test
    void TC020_naoDeveAtualizarPerfilComEmailInvalido() {

        Usuario usuario = new Usuario(
                "João",
                "",
                "81999999999",
                "50700000",
                "123456"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            perfilService.atualizarPerfil(usuario);
        });

        verify(repository, never()).salvar(any());
    }

    @Test
    void TC021_naoDeveAtualizarPerfilComTelefoneInvalido() {

        Usuario usuario = new Usuario(
                "João",
                "joao@email.com",
                "",
                "50700000",
                "123456"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            perfilService.atualizarPerfil(usuario);
        });

        verify(repository, never()).salvar(any());
    }

    @Test
    void TC022_naoDeveAtualizarPerfilComCepInvalido() {

        Usuario usuario = new Usuario(
                "João",
                "joao@email.com",
                "81999999999",
                "",
                "123456"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            perfilService.atualizarPerfil(usuario);
        });

        verify(repository, never()).salvar(any());
    }

    @Test
    void TC023_naoDeveAtualizarPerfilComNomeInvalido() {

        Usuario usuario = new Usuario(
                "",
                "joao@email.com",
                "81999999999",
                "50700000",
                "123456"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            perfilService.atualizarPerfil(usuario);
        });

        verify(repository, never()).salvar(any());
    }

    @Test
    void TC024_naoDeveAtualizarPerfilComSenhaInvalida() {

        Usuario usuario = new Usuario(
                "João",
                "joao@email.com",
                "81999999999",
                "50700000",
                ""
        );

        assertThrows(IllegalArgumentException.class, () -> {
            perfilService.atualizarPerfil(usuario);
        });

        verify(repository, never()).salvar(any());
    }
}