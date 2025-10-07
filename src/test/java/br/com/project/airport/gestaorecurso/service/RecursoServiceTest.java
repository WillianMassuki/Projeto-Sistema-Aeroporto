package br.com.project.airport.gestaorecurso.service;

import br.com.project.airport.gestaorecurso.model.Recurso;
import br.com.project.airport.gestaorecurso.out.RecursoRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecursoServiceTest {

    @Mock
    private RecursoRepositoryPort repository;

    @InjectMocks
    private RecursoService service;

    private Recurso recurso;

    @BeforeEach
    void setUp() {
        recurso = mock(Recurso.class);
        when(recurso.getIdRecurso()).thenReturn("abc123");
    }

    @Test
    void criar_deveSalvarRecursoComSucesso() {
        when(repository.salvar(recurso)).thenReturn(recurso);

        Recurso resultado = service.criar(recurso);

        assertNotNull(resultado);
        verify(repository).salvar(recurso);
    }

    @Test
    void buscarPorId_deveRetornarRecursoQuandoExistir() {
        when(repository.buscarPorId("abc123")).thenReturn(Optional.of(recurso));

        Recurso resultado = service.buscarPorId("abc123");

        assertNotNull(resultado);
        verify(repository).buscarPorId("abc123");
    }

    @Test
    void buscarPorId_deveLancarExcecaoQuandoNaoExistir() {
        when(repository.buscarPorId("xyz")).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> service.buscarPorId("xyz"));

        assertTrue(ex.getMessage().contains("Recurso não encontrado"));
        verify(repository).buscarPorId("xyz");
    }

    @Test
    void listarTodos_deveRetornarListaDeRecursos() {
        List<Recurso> lista = Arrays.asList(mock(Recurso.class), mock(Recurso.class));
        when(repository.buscarTodos()).thenReturn(lista);

        List<Recurso> resultado = service.listarTodos();

        assertEquals(2, resultado.size());
        verify(repository).buscarTodos();
    }

    @Test
    void deletar_deveChamarRepositoryDeletar() {
        doNothing().when(repository).deletar("abc123");

        service.deletar("abc123");

        verify(repository).deletar("abc123");
    }

    @Test
    void alocar_deveChamarAlocarESalvar() {
        when(repository.buscarPorId("abc123")).thenReturn(Optional.of(recurso));
        when(repository.salvar(recurso)).thenReturn(recurso);

        Recurso resultado = service.alocar("abc123");

        assertNotNull(resultado);
        verify(recurso).alocar();
        verify(repository).salvar(recurso);
    }

    @Test
    void liberar_deveChamarLiberarESalvar() {
        when(repository.buscarPorId("abc123")).thenReturn(Optional.of(recurso));
        when(repository.salvar(recurso)).thenReturn(recurso);

        Recurso resultado = service.liberar("abc123");

        assertNotNull(resultado);
        verify(recurso).liberar();
        verify(repository).salvar(recurso);
    }
}