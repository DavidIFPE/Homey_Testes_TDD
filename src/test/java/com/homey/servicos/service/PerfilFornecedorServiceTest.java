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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class PerfilFornecedorServiceTest {

    @Mock
    PerfilFornecedorRepository repository;

    @InjectMocks
    PerfilFornecedorService service;

    // TC_025
    @Test
    void deveAtualizarPerfilComDadosValidos() {

        PerfilFornecedor perfil = new PerfilFornecedor(
                "Pintura",
                "Sou pintora profissional",
                "Diária",
                500
        );

        service.atualizarPerfil(perfil);

        verify(repository, times(1)).salvar(perfil);
    }

    // TC_026
    @Test
    void naoDeveSalvarCategoriaInvalida() {

        PerfilFornecedor perfil = new PerfilFornecedor(
                "",
                "Descricao valida",
                "Diária",
                500
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.atualizarPerfil(perfil)
        );

        verify(repository, never()).salvar(any());
    }

    // TC_027
    @Test
    void naoDeveSalvarPrecificacaoInvalida() {

        PerfilFornecedor perfil = new PerfilFornecedor(
                "Pintura",
                "Descricao valida",
                "Diárishsj", // inválida
                500
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.atualizarPerfil(perfil)
        );

        verify(repository, never()).salvar(any());
    }

    // TC_028
    @Test
    void naoDeveSalvarPrecoInvalido() {

        PerfilFornecedor perfil = new PerfilFornecedor(
                "Pintura",
                "Descricao valida",
                "Diária",
                -10
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.atualizarPerfil(perfil)
        );

        verify(repository, never()).salvar(any());
    }
}
