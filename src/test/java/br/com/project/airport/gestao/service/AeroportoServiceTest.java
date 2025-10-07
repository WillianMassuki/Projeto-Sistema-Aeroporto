package br.com.project.airport.gestao.service;

import br.com.project.airport.gestao.model.Aeroporto;
import br.com.project.airport.gestao.out.AeroportoRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AeroportoServiceTest {


    private AeroportoRepositoryPort repository;
    private AeroportoService service;

    @BeforeEach
    void setUp() {
        repository = mock(AeroportoRepositoryPort.class);
        service = new AeroportoService(repository);
    }

    @Test
    @DisplayName("Deve salvar um aeroporto com sucesso")
    void deveSalvarAeroporto() {
        Aeroporto aeroporto = new Aeroporto();
        aeroporto.setNome("Guarulhos");
        when(repository.salvar(aeroporto)).thenReturn(aeroporto);

        Aeroporto resultado = service.salvar(aeroporto);

        assertEquals("Guarulhos", resultado.getNome());
        verify(repository, times(1)).salvar(aeroporto);
    }

    @Test
    @DisplayName("Deve listar aeroportos corretamente")
    void deveListarAeroportos() {
        List<Aeroporto> lista = List.of(new Aeroporto(), new Aeroporto());
        when(repository.listar()).thenReturn(lista);

        List<Aeroporto> resultado = service.listar();

        assertEquals(2, resultado.size());
        verify(repository, times(1)).listar();
    }

    @Test
    @DisplayName("Deve buscar aeroporto por ID com sucesso")
    void deveBuscarPorId() {
        Aeroporto aeroporto = new Aeroporto();
        aeroporto.setNome("Congonhas");
        when(repository.buscarPorId(1L)).thenReturn(Optional.of(aeroporto));

        Aeroporto resultado = service.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals("Congonhas", resultado.getNome());
        verify(repository).buscarPorId(1L);
    }

    @Test
    @DisplayName("Deve lançar exceção ao buscar aeroporto inexistente")
    void deveLancarExcecaoQuandoNaoEncontrado() {
        when(repository.buscarPorId(999L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> service.buscarPorId(999L));

        assertEquals("Aeroporto não encontrado", ex.getMessage());
        verify(repository).buscarPorId(999L);
    }

    @Test
    @DisplayName("Deve atualizar um aeroporto existente")
    void deveAtualizarAeroporto() {
        Aeroporto existente = new Aeroporto();
        existente.setIdAeroporto(1L);
        existente.setNome("Velho Nome");
        existente.setCodigo("ABC");

        Aeroporto novo = new Aeroporto();
        novo.setNome("Novo Nome");
        novo.setCodigo("XYZ");

        when(repository.buscarPorId(1L)).thenReturn(Optional.of(existente));
        when(repository.salvar(any(Aeroporto.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Aeroporto resultado = service.atualizar(1L, novo);

        ArgumentCaptor<Aeroporto> captor = ArgumentCaptor.forClass(Aeroporto.class);
        verify(repository).salvar(captor.capture());
        Aeroporto salvo = captor.getValue();

        assertEquals("Novo Nome", salvo.getNome());
        assertEquals("XYZ", salvo.getCodigo());
        assertSame(resultado, salvo);
    }

    @Test
    @DisplayName("Deve deletar aeroporto corretamente")
    void deveDeletarAeroporto() {
        service.deletar(5L);
        verify(repository, times(1)).deletar(5L);
    }

    @Test
    @DisplayName("Método gerenciarFuncionarios deve ser vazio, mas não lançar exceção")
    void gerenciarFuncionariosNaoDeveLancarErro() {
        assertDoesNotThrow(() -> service.gerenciarFuncionarios());
    }
}
