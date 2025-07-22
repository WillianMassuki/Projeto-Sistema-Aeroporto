package br.com.project.airport.comunicacao.service;

import br.com.project.airport.comunicacao.model.Informacao;
import br.com.project.airport.comunicacao.out.InformacaoRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class InformacaoServiceTest {

    @Mock
    private InformacaoRepositoryPort repository;

    @InjectMocks
    private InformacaoService service;

    private Informacao informacao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        informacao = new Informacao();
        informacao.setIdInformacao("123");
        informacao.setTipo("ALERTA");
        informacao.setConteudo("Informação importante");
        informacao.setValidade(LocalDate.now().plusDays(3).atStartOfDay());
    }

    @Test
    void testCriar() {
        when(repository.salvar(informacao)).thenReturn(informacao);

        Informacao result = service.criar(informacao);

        assertEquals(informacao, result);
        verify(repository).salvar(informacao);
    }

    @Test
    void testBuscarPorId() {
        when(repository.buscarPorId("123")).thenReturn(Optional.of(informacao));

        Optional<Informacao> result = service.buscarPorId("123");

        assertTrue(result.isPresent());
        assertEquals("ALERTA", result.get().getTipo());
        verify(repository).buscarPorId("123");
    }

    @Test
    void testListar() {
        List<Informacao> informacoes = List.of(informacao);
        when(repository.buscarTodos()).thenReturn(informacoes);

        List<Informacao> result = service.listar();

        assertEquals(1, result.size());
        verify(repository).buscarTodos();
    }

    @Test
    void testAtualizarComSucesso() {
        Informacao novaInfo = new Informacao();
        novaInfo.setTipo("ATUALIZADO");
        novaInfo.setConteudo("Novo conteúdo");
        novaInfo.setValidade(LocalDate.now().plusDays(10).atStartOfDay());

        when(repository.buscarPorId("123")).thenReturn(Optional.of(informacao));
        when(repository.salvar(any(Informacao.class))).thenAnswer(inv -> inv.getArgument(0));

        Informacao result = service.atualizar("123", novaInfo);

        assertEquals("ATUALIZADO", result.getTipo());
        assertEquals("Novo conteúdo", result.getConteudo());
        verify(repository).buscarPorId("123");
        verify(repository).salvar(any(Informacao.class));
    }

    @Test
    void testAtualizarComErro() {
        when(repository.buscarPorId("999")).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                service.atualizar("999", informacao)
        );

        assertEquals("Informação não encontrada", exception.getMessage());
        verify(repository).buscarPorId("999");
        verify(repository, never()).salvar(any());
    }

    @Test
    void testDeletar() {
        doNothing().when(repository).deletarPorId("123");

        service.deletar("123");

        verify(repository).deletarPorId("123");
    }
}
