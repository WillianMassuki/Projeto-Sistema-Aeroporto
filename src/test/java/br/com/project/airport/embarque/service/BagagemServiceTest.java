package br.com.project.airport.embarque.service;

import br.com.project.airport.embarque.model.Bagagem;
import br.com.project.airport.embarque.out.BagagemRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class BagagemServiceTest {

    @Mock
    private BagagemRepositoryPort repository;

    @InjectMocks
    private BagagemService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarBagagemComSucesso() {
        Bagagem bagagem = new Bagagem(1L, "Mala", 20.5);
        when(repository.salvar(bagagem)).thenReturn(bagagem);

        Bagagem resultado = service.salvar(bagagem);

        assertEquals(bagagem, resultado);
        verify(repository).salvar(bagagem);
    }

    @Test
    void deveListarBagagens() {
        List<Bagagem> lista = List.of(
                new Bagagem(1L, "Mala", 22.0),
                new Bagagem(2L, "Bolsa", 10.0)
        );
        when(repository.listar()).thenReturn(lista);

        List<Bagagem> resultado = service.listar();

        assertEquals(2, resultado.size());
        verify(repository).listar();
    }

    @Test
    void deveBuscarBagagemPorIdExistente() {
        Bagagem bagagem = new Bagagem(1L, "Mala", 23.0);
        when(repository.buscarPorId(1L)).thenReturn(Optional.of(bagagem));

        Bagagem resultado = service.buscarPorId(1L);

        assertEquals(bagagem, resultado);
        verify(repository).buscarPorId(1L);
    }

    @Test
    void deveLancarExcecaoAoBuscarBagagemInexistente() {
        when(repository.buscarPorId(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> service.buscarPorId(99L));

        assertEquals("Bagagem não encontrada", ex.getMessage());
        verify(repository).buscarPorId(99L);
    }

    @Test
    void deveAtualizarBagagemComSucesso() {
        Bagagem existente = new Bagagem(1L, "Mala", 20.0);
        Bagagem nova = new Bagagem(null, "Bolsa", 15.0);

        when(repository.buscarPorId(1L)).thenReturn(Optional.of(existente));
        when(repository.salvar(any(Bagagem.class))).thenReturn(existente);

        Bagagem resultado = service.atualizar(1L, nova);

        assertEquals("Bolsa", resultado.getNome());
        assertEquals(15.0, resultado.getPeso());
        verify(repository).buscarPorId(1L);
        verify(repository).salvar(existente);
    }

    @Test
    void deveDeletarBagagemPorId() {
        doNothing().when(repository).deletar(1L);

        service.deletar(1L);

        verify(repository).deletar(1L);
    }

}
