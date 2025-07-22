package br.com.project.airport.comunicacao.service;

import br.com.project.airport.comunicacao.model.Funcionario;
import br.com.project.airport.comunicacao.out.FuncionarioRepositoryOutPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FuncionarioServiceTest {

    private FuncionarioRepositoryOutPort repository;
    private FuncionarioService service;

    @BeforeEach
    void setUp() {
        repository = mock(FuncionarioRepositoryOutPort.class);
        service = new FuncionarioService(repository);
    }

    @Test
    void deveCriarFuncionario() {
        Funcionario funcionario = new Funcionario(1L, "João", "Analista", "123");

        when(repository.salvar(funcionario)).thenReturn(funcionario);

        Funcionario result = service.criar(funcionario);

        assertEquals(funcionario, result);
        verify(repository).salvar(funcionario);
    }

    @Test
    void deveBuscarFuncionarioPorId() {
        Funcionario funcionario = new Funcionario(1L, "João", "Analista", "123");

        when(repository.buscarPorId(1L)).thenReturn(Optional.of(funcionario));

        Optional<Funcionario> result = service.buscarPorId(1L);

        assertTrue(result.isPresent());
        assertEquals(funcionario, result.get());
    }

    @Test
    void deveListarTodosFuncionarios() {
        List<Funcionario> lista = Arrays.asList(
                new Funcionario(1L, "João", "Analista", "123"),
                new Funcionario(2L, "Maria", "Gerente", "456")
        );

        when(repository.buscarTodos()).thenReturn(lista);

        List<Funcionario> result = service.listar();

        assertEquals(2, result.size());
        assertEquals("João", result.get(0).getNome());
    }

    @Test
    void deveAtualizarFuncionarioExistente() {
        Funcionario existente = new Funcionario(1L, "João", "Analista", "123");
        Funcionario atualizacao = new Funcionario(null, "Joana", "Gerente", "456");
        Funcionario atualizadoEsperado = new Funcionario(1L, "Joana", "Gerente", "456");

        when(repository.buscarPorId(1L)).thenReturn(Optional.of(existente));
        when(repository.salvar(any())).thenReturn(atualizadoEsperado);

        Funcionario result = service.atualizar(1L, atualizacao);

        assertEquals("Joana", result.getNome());
        assertEquals("Gerente", result.getCargo());
        assertEquals("456", result.getMatricula());

        ArgumentCaptor<Funcionario> captor = ArgumentCaptor.forClass(Funcionario.class);
        verify(repository).salvar(captor.capture());
        assertEquals("Joana", captor.getValue().getNome());
    }

    @Test
    void deveLancarExcecaoAoAtualizarFuncionarioInexistente() {
        when(repository.buscarPorId(99L)).thenReturn(Optional.empty());

        Funcionario atualizacao = new Funcionario(null, "Novo", "NovoCargo", "000");

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.atualizar(99L, atualizacao);
        });

        assertEquals("Funcionario não encontrado", exception.getMessage());
    }

    @Test
    void deveDeletarFuncionarioPorId() {
        Long id = 1L;

        service.deletar(id);

        verify(repository).deletarPorId(id);
    }
}
