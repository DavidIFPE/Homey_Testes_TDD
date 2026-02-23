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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class BuscaServiceTest {

    @Mock
    ServicoRepository repository;

    @InjectMocks
    BuscaService service;

    @Test
    void deveBuscarServicosComPalavraChaveValida() {

        List<Servico> lista = List.of(
                new Servico("Pintor", "Pintura", 100, 5, 2)
        );

        when(repository.buscarPorPalavraChave("Pintor"))
                .thenReturn(lista);

        List<Servico> resultado =
                service.buscar("Pintor");

        assertFalse(resultado.isEmpty());

        verify(repository, times(1))
                .buscarPorPalavraChave("Pintor");
    }

    @Test
    void naoDeveBuscarComPalavraChaveVazia() {

        assertThrows(
                IllegalArgumentException.class,
                () -> service.buscar("")
        );

        verify(repository, never())
                .buscarPorPalavraChave(any());
    }
    @Test
    void naoDeveBuscarComNotaInvalida() {

        assertThrows(
                IllegalArgumentException.class,
                () -> service.buscarComFiltros(
                        "Pintor",
                        13, // nota inválida
                        5,
                        100
                )
        );

        verify(repository, never())
                .buscarPorPalavraChave(any());
    }
    
    @Test
    void naoDeveBuscarComDistanciaInvalida() {

        assertThrows(
                IllegalArgumentException.class,
                () -> service.buscarComFiltros(
                        "Pintor",
                        4,
                        -1, // distância inválida
                        100
                )
        );

        verify(repository, never())
                .buscarPorPalavraChave(any());
    }
    
    @Test
    void naoDeveBuscarComPrecoInvalido() {

        assertThrows(
                IllegalArgumentException.class,
                () -> service.buscarComFiltros(
                        "Pintor",
                        4,
                        5,
                        -10 // preço inválido
                )
        );

        verify(repository, never())
                .buscarPorPalavraChave(any());
    }
    
    @Test
    void deveRetornarListaVaziaQuandoNenhumProfissionalEncontrado() {

        when(repository.buscarPorPalavraChave("Pintor"))
                .thenReturn(List.of());

        List<Servico> resultado =
                service.buscarComFiltros("Pintor", 4, 5, 100);

        assertTrue(resultado.isEmpty());

        verify(repository, times(1))
                .buscarPorPalavraChave("Pintor");
    }
}
