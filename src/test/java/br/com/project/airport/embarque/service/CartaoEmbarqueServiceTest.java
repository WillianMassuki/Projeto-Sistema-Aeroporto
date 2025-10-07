package br.com.project.airport.embarque.service;

import br.com.project.airport.embarque.model.CartaoEmbarque;
import br.com.project.airport.embarque.out.CartaoEmbarqueRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CartaoEmbarqueServiceTest {


    @Mock
    private CartaoEmbarqueRepositoryPort repository;

    @InjectMocks
    private CartaoEmbarqueService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarCartaoComSucesso() {
        CartaoEmbarque cartao = new CartaoEmbarque();
        when(repository.salvar(cartao)).thenReturn(cartao);

        CartaoEmbarque resultado = service.salvar(cartao);

        assertEquals(cartao, resultado);
        verify(repository, times(1)).salvar(cartao);
    }

    @Test
    void deveListarCartoes() {
        CartaoEmbarque c1 = new CartaoEmbarque();
        CartaoEmbarque c2 = new CartaoEmbarque();
        when(repository.listar()).thenReturn(List.of(c1, c2));

        List<CartaoEmbarque> lista = service.listar();

        assertEquals(2, lista.size());
        verify(repository).listar();
    }

    @Test
    void deveBuscarCartaoPorIdComSucesso() {
        Long id = 1L;
        CartaoEmbarque cartao = new CartaoEmbarque();
        when(repository.buscarPorId(id)).thenReturn(Optional.of(cartao));

        CartaoEmbarque resultado = service.buscarPorId(id);

        assertNotNull(resultado);
        assertEquals(cartao, resultado);
        verify(repository).buscarPorId(id);
    }

    @Test
    void deveLancarExcecaoAoBuscarCartaoInexistente() {
        Long id = 99L;
        when(repository.buscarPorId(id)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> service.buscarPorId(id));

        assertEquals("Cartão não encontrado", ex.getMessage());
        verify(repository).buscarPorId(id);
    }

    @Test
    void deveAtualizarCartaoComSucesso() {
        Long id = 1L;
        CartaoEmbarque existente = new CartaoEmbarque();
        existente.setCodigoCartaoEmbarque("OLD");
        existente.setAssento("1A");

        CartaoEmbarque novo = new CartaoEmbarque();
        novo.setCodigoCartaoEmbarque("NEW");
        novo.setAssento("2B");

        when(repository.buscarPorId(id)).thenReturn(Optional.of(existente));
        when(repository.salvar(any())).thenAnswer(invocation -> invocation.getArgument(0));

        CartaoEmbarque atualizado = service.atualizar(id, novo);

        assertEquals("NEW", atualizado.getCodigoCartaoEmbarque());
        assertEquals("2B", atualizado.getAssento());

        ArgumentCaptor<CartaoEmbarque> captor = ArgumentCaptor.forClass(CartaoEmbarque.class);
        verify(repository).salvar(captor.capture());
        CartaoEmbarque salvo = captor.getValue();
        assertEquals("NEW", salvo.getCodigoCartaoEmbarque());
        assertEquals("2B", salvo.getAssento());
    }

    @Test
    void deveDeletarCartaoPorId() {
        Long id = 10L;

        service.deletar(id);

        verify(repository, times(1)).deletar(id);
    }
}
