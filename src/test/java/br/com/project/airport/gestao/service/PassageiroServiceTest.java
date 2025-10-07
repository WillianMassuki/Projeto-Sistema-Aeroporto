package br.com.project.airport.gestao.service;

import br.com.project.airport.gestao.model.Passageiro;
import br.com.project.airport.gestao.out.PassageiroRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PassageiroServiceTest {

    @Mock
    private PassageiroRepositoryPort repository;

    @InjectMocks
    private PassageiroService service;

    private Passageiro passageiro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        passageiro = new Passageiro();
        passageiro.setCodigoPassageiro(1L);
        passageiro.setNome("João Silva");
        passageiro.setDocumento("123456789");
        passageiro.setNumeroCartao("987654321");
    }

    @Test
    void deveSalvarPassageiro() {
        when(repository.salvar(passageiro)).thenReturn(passageiro);

        Passageiro resultado = service.salvar(passageiro);

        assertEquals(passageiro, resultado);
        verify(repository).salvar(passageiro);
    }

    @Test
    void deveListarPassageiros() {
        List<Passageiro> lista = List.of(passageiro);
        when(repository.listar()).thenReturn(lista);

        List<Passageiro> resultado = service.listar();

        assertEquals(1, resultado.size());
        assertEquals("João Silva", resultado.get(0).getNome());
        verify(repository).listar();
    }

    @Test
    void deveBuscarPassageiroPorId() {
        when(repository.buscarPorId(1L)).thenReturn(passageiro);

        Passageiro resultado = service.buscarPorId(1L);

        assertEquals("João Silva", resultado.getNome());
        verify(repository).buscarPorId(1L);
    }

    @Test
    void deveAtualizarPassageiro() {
        Passageiro novo = new Passageiro();
        novo.setNome("Maria Oliveira");
        novo.setDocumento("999888777");
        novo.setNumeroCartao("111222333");

        when(repository.buscarPorId(1L)).thenReturn(passageiro);
        when(repository.salvar(any(Passageiro.class))).thenAnswer(inv -> inv.getArgument(0));

        Passageiro atualizado = service.atualizar(1L, novo);

        assertEquals("Maria Oliveira", atualizado.getNome());
        assertEquals("999888777", atualizado.getDocumento());
        assertEquals("111222333", atualizado.getNumeroCartao());
        verify(repository).salvar(passageiro);
    }

    @Test
    void deveDeletarPassageiro() {
        doNothing().when(repository).deletar(1L);

        service.deletar(1L);

        verify(repository).deletar(1L);
    }
}