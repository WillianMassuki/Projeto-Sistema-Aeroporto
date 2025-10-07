package br.com.project.airport.gestao.service;

import br.com.project.airport.gestao.model.Bilhete;
import br.com.project.airport.gestao.out.BilheteRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BilheteServiceTest {

    @Mock
    private BilheteRepositoryPort repository;

    @InjectMocks
    private BilheteService service;

    private Bilhete bilhete;

    @BeforeEach
    void setup() {
        bilhete = new Bilhete();
        bilhete.setIdBilhete(1L);
        bilhete.setNumero(Integer.valueOf("ABC123"));
        bilhete.setAssento("12A");
        bilhete.setBagagem(true);
        bilhete.setPassageiro("João Silva");
    }

    @Test
    void deveSalvarBilheteComSucesso() {
        when(repository.salvar(bilhete)).thenReturn(bilhete);

        Bilhete resultado = service.salvar(bilhete);

        assertNotNull(resultado);
        assertEquals("ABC123", resultado.getNumero());
        verify(repository, times(1)).salvar(bilhete);
    }

    @Test
    void deveListarTodosOsBilhetes() {
        when(repository.listar()).thenReturn(List.of(bilhete));

        List<Bilhete> bilhetes = service.listar();

        assertEquals(1, bilhetes.size());
        assertEquals("João Silva", bilhetes.get(0).getPassageiro());
        verify(repository, times(1)).listar();
    }

    @Test
    void deveBuscarBilhetePorId() {
        when(repository.buscarPorId(1L)).thenReturn(Optional.of(bilhete));

        Bilhete resultado = service.buscarPorId(1L);

        assertEquals("12A", resultado.getAssento());
        verify(repository, times(1)).buscarPorId(1L);
    }

    @Test
    void deveLancarExcecaoQuandoBilheteNaoEncontrado() {
        when(repository.buscarPorId(999L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> service.buscarPorId(999L));

        assertEquals("Bilhete não encontrado", ex.getMessage());
        verify(repository, times(1)).buscarPorId(999L);
    }

    @Test
    void deveAtualizarBilheteComSucesso() {
        Bilhete novo = new Bilhete();
        novo.setNumero(Integer.valueOf("XYZ789"));
        novo.setAssento("15B");
        novo.setBagagem(false);
        novo.setPassageiro("Maria Souza");

        when(repository.buscarPorId(1L)).thenReturn(Optional.of(bilhete));
        when(repository.salvar(any(Bilhete.class))).thenReturn(novo);

        Bilhete resultado = service.atualizar(1L, novo);

        assertEquals("XYZ789", resultado.getNumero());
        assertEquals("Maria Souza", resultado.getPassageiro());

        ArgumentCaptor<Bilhete> captor = ArgumentCaptor.forClass(Bilhete.class);
        verify(repository).salvar(captor.capture());

        Bilhete capturado = captor.getValue();
        assertEquals("15B", capturado.getAssento());
        assertFalse(capturado.getBagagem());
    }

    @Test
    void deveDeletarBilhetePorId() {
        doNothing().when(repository).deletar(1L);

        service.deletar(1L);

        verify(repository, times(1)).deletar(1L);
    }
}