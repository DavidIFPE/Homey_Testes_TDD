/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.homey.servicos.service;

import com.homey.servicos.model.Contrato;
import com.homey.servicos.model.Servico;
import com.homey.servicos.repository.ContratoRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ContratoServiceTest {

    @Mock
    ContratoRepository repository;

    @InjectMocks
    ContratoService service;

    @Test
    void deveCriarContratoComDadosValidos() {

        Contrato contrato = new Contrato(
                "João",
                "Maria",
                new Servico("Pintor", "Pintura", 100, 5, 2),
                300,
                "2026-02-20",
                "2026-02-21"
        );

        service.criarContrato(contrato);

        verify(repository, times(1)).salvar(contrato);
    }

    @Test
    void naoDeveSalvarContratoNulo() {

        assertThrows(
                IllegalArgumentException.class,
                () -> service.criarContrato(null)
        );

        verify(repository, never()).salvar(any());
    }

    @Test
    void naoDeveSalvarSemCliente() {

        Contrato contrato = new Contrato(
                "",
                "Maria",
                new Servico("Pintor", "Pintura", 100, 5, 2),
                300,
                "2026-02-20",
                "2026-02-21"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.criarContrato(contrato)
        );

        verify(repository, never()).salvar(any());
    }

    @Test
    void naoDeveSalvarValorInvalido() {

        Contrato contrato = new Contrato(
                "João",
                "Maria",
                new Servico("Pintor", "Pintura", 100, 5, 2),
                -50,
                "2026-02-20",
                "2026-02-21"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.criarContrato(contrato)
        );

        verify(repository, never()).salvar(any());
    }
}
