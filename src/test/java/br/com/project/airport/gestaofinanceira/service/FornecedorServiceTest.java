package br.com.project.airport.gestaofinanceira.service;

import br.com.project.airport.gestaofinanceira.model.Fornecedor;
import br.com.project.airport.gestaofinanceira.out.FornecedorRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FornecedorServiceTest {

    @Mock
    private FornecedorRepositoryPort repository;

    @InjectMocks
    private FornecedorService service;

    private Fornecedor fornecedor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        fornecedor = new Fornecedor();
        fornecedor.setIdFornecedor("1");
        fornecedor.setNome("Fornecedor X");
        fornecedor.setServicoPrestado("Transporte");
    }

    @Test
    void deveSalvarFornecedor() {
        when(repository.salvar(fornecedor)).thenReturn(fornecedor);

        Fornecedor salvo = service.salvar(fornecedor);

        assertNotNull(salvo);
        assertEquals("Fornecedor X", salvo.getNome());
        verify(repository, times(1)).salvar(fornecedor);
    }

    @Test
    void deveListarFornecedores() {
        when(repository.listar()).thenReturn(Arrays.asList(fornecedor));

        List<Fornecedor> lista = service.listar();

        assertEquals(1, lista.size());
        verify(repository, times(1)).listar();
    }

    @Test
    void deveBuscarPorIdQuandoExiste() {
        when(repository.buscarPorId(1L)).thenReturn(Optional.of(fornecedor));

        Fornecedor encontrado = service.buscarPorId(1L);

        assertNotNull(encontrado);
        assertEquals("1", encontrado.getIdFornecedor());
        verify(repository, times(1)).buscarPorId(1L);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarFornecedor() {
        when(repository.buscarPorId(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> service.buscarPorId(99L));
        assertEquals("Fornecedor não encontrado", ex.getMessage());
    }

    @Test
    void deveAtualizarFornecedor() {
        Fornecedor novo = new Fornecedor();
        novo.setNome("Fornecedor Atualizado");
        novo.setServicoPrestado("Logística");

        when(repository.buscarPorId(1L)).thenReturn(Optional.of(fornecedor));
        when(repository.salvar(any(Fornecedor.class))).thenReturn(fornecedor);

        Fornecedor atualizado = service.atualizar(1L, novo);

        assertEquals("Fornecedor Atualizado", atualizado.getNome());
        assertEquals("Logística", atualizado.getServicoPrestado());
        verify(repository).salvar(fornecedor);
    }

    @Test
    void deveDeletarFornecedor() {
        doNothing().when(repository).deletar(1L);

        service.deletar(1L);

        verify(repository, times(1)).deletar(1L);
    }
}