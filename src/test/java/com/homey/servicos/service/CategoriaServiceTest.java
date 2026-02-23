package com.homey.servicos.service;

import com.homey.servicos.model.Categoria;
import com.homey.servicos.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {

    @Mock
    CategoriaRepository repository;

    @InjectMocks
    CategoriaService service;

    @Test
    void deveCriarCategoriaComDadosValidos() {

        Categoria categoria = new Categoria();
        categoria.setNome("Construção");

        service.criarCategoria(categoria);

        verify(repository, times(1)).salvar(categoria);
    }

    @Test
    void naoDeveSalvarCategoriaNula() {

        assertThrows(
                IllegalArgumentException.class,
                () -> service.criarCategoria(null)
        );

        verify(repository, never()).salvar(any());
    }

    @Test
    void naoDeveSalvarSemNome() {

        Categoria categoria = new Categoria();
        categoria.setNome("");

        assertThrows(
                IllegalArgumentException.class,
                () -> service.criarCategoria(categoria)
        );

        verify(repository, never()).salvar(any());
    }

    @Test
    void deveDefinirDataCriacaoQuandoNaoInformada() {

        Categoria categoria = new Categoria();
        categoria.setNome("Jardinagem");
        // dataCriacao não definida

        ArgumentCaptor<Categoria> captor = ArgumentCaptor.forClass(Categoria.class);

        service.criarCategoria(categoria);

        verify(repository, times(1)).salvar(captor.capture());

        assertNotNull(captor.getValue().getDataCriacao());
        assertFalse(captor.getValue().getDataCriacao().isBlank());
    }
}
