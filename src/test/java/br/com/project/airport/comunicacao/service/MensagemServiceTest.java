package br.com.project.airport.comunicacao.service;

import br.com.project.airport.comunicacao.model.Mensagem;
import br.com.project.airport.comunicacao.out.MensagemRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MensagemServiceTest {

    private MensagemRepositoryPort repository;
    private MensagemService service;

    private Mensagem mensagem;

    @BeforeEach
    void setup() {
        repository = mock(MensagemRepositoryPort.class);
        service = new MensagemService(repository);

        mensagem = new Mensagem();
       // mensagem.setId("1");
        mensagem.setRemetente("João");
        mensagem.setDestinatario("Maria");
        mensagem.setConteudo("Olá, Maria!");
        mensagem.setDataHora(LocalDateTime.now());
    }

    @Test
    void deveCriarMensagem() {
        when(repository.salvar(any())).thenReturn(mensagem);

        Mensagem resultado = service.criar(mensagem);

        assertNotNull(resultado);
     //   assertEquals("1", resultado.getId());
        verify(repository).salvar(mensagem);
    }

    @Test
    void deveBuscarMensagemPorId() {
        when(repository.buscarPorId("1")).thenReturn(Optional.of(mensagem));

        Optional<Mensagem> resultado = service.buscarPorId("1");

        assertTrue(resultado.isPresent());
        assertEquals("João", resultado.get().getRemetente());
    }

    @Test
    void deveListarTodasMensagens() {
        when(repository.buscarTodos()).thenReturn(Arrays.asList(mensagem));

        List<Mensagem> mensagens = service.listar();

        assertEquals(1, mensagens.size());
        assertEquals("Maria", mensagens.get(0).getDestinatario());
    }

    @Test
    void deveAtualizarMensagemExistente() {
        Mensagem nova = new Mensagem();
        nova.setRemetente("Carlos");
        nova.setDestinatario("Ana");
        nova.setConteudo("Oi Ana");
        nova.setDataHora(LocalDateTime.now());

        when(repository.buscarPorId("1")).thenReturn(Optional.of(mensagem));
        when(repository.salvar(any())).thenReturn(mensagem);

        Mensagem resultado = service.atualizar("1", nova);

        assertEquals("Carlos", resultado.getRemetente());
        assertEquals("Ana", resultado.getDestinatario());
        verify(repository).salvar(any(Mensagem.class));
    }

    @Test
    void deveLancarExcecaoAoAtualizarMensagemInexistente() {
        when(repository.buscarPorId("999")).thenReturn(Optional.empty());

        Mensagem nova = new Mensagem();
        nova.setRemetente("Carlos");

        RuntimeException thrown = assertThrows(RuntimeException.class, () ->
                service.atualizar("999", nova)
        );

        assertEquals("Mensagem não encontrada", thrown.getMessage());
    }

    @Test
    void deveDeletarMensagem() {
        doNothing().when(repository).deletarPorId("1");

        service.deletar("1");

        verify(repository).deletarPorId("1");
    }
}
