package br.com.project.airport.gestaorecurso.service;

import br.com.project.airport.gestaorecurso.model.Pista;
import br.com.project.airport.gestaorecurso.out.PistaRepositoryPort;
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
class PistaServiceTest {

    @Mock
    private PistaRepositoryPort pistaRepositoryPort;

    @InjectMocks
    private PistaService pistaService;

    private Pista pista;

    @BeforeEach
    void setUp() {
        pista = new Pista();
        pista.setIdPista(String.valueOf(1L));
        pista.setStatus("LIVRE");
    }

    @Test
    void criarPista_deveSalvarEPersistirComSucesso() {
        when(pistaRepositoryPort.salvar(pista)).thenReturn(pista);

        Pista resultado = pistaService.criarPista(pista);

        assertNotNull(resultado);
        assertEquals("LIVRE", resultado.getStatus());
        verify(pistaRepositoryPort, times(1)).salvar(pista);
    }

    @Test
    void buscarPorId_deveRetornarPistaQuandoExistir() {
        when(pistaRepositoryPort.buscarPorId(1L)).thenReturn(Optional.of(pista));

        Optional<Pista> resultado = pistaService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("LIVRE", resultado.get().getStatus());
        verify(pistaRepositoryPort).buscarPorId(1L);
    }

    @Test
    void buscarPorId_deveRetornarVazioQuandoNaoExistir() {
        when(pistaRepositoryPort.buscarPorId(99L)).thenReturn(Optional.empty());

        Optional<Pista> resultado = pistaService.buscarPorId(99L);

        assertTrue(resultado.isEmpty());
        verify(pistaRepositoryPort).buscarPorId(99L);
    }

    @Test
    void listarTodas_deveRetornarListaDePistas() {
        List<Pista> lista = Arrays.asList(pista, new Pista());
        when(pistaRepositoryPort.buscarTodas()).thenReturn(lista);

        List<Pista> resultado = pistaService.listarTodas();

        assertEquals(2, resultado.size());
        verify(pistaRepositoryPort).buscarTodas();
    }

    @Test
    void atualizarPista_deveAtualizarQuandoExistir() {
        Pista nova = new Pista();
        nova.setStatus("OCUPADA");

        when(pistaRepositoryPort.buscarPorId(1L)).thenReturn(Optional.of(pista));
        when(pistaRepositoryPort.salvar(any(Pista.class))).thenReturn(pista);

        Pista resultado = pistaService.atualizarPista(1L, nova);

        assertEquals("OCUPADA", resultado.getStatus());
        verify(pistaRepositoryPort).salvar(pista);
    }

    @Test
    void atualizarPista_deveLancarExcecaoQuandoNaoEncontrar() {
        Pista nova = new Pista();
        when(pistaRepositoryPort.buscarPorId(999L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                pistaService.atualizarPista(999L, nova)
        );

        assertTrue(ex.getMessage().contains("Pista não encontrada"));
        verify(pistaRepositoryPort, never()).salvar(any());
    }

    @Test
    void deletarPista_deveChamarDeletarPorId() {
        doNothing().when(pistaRepositoryPort).deletarPorId(1L);

        pistaService.deletarPista(1L);

        verify(pistaRepositoryPort).deletarPorId(1L);
    }

    @Test
    void agendarUso_deveRetornarStringVazia() {
        String resultado = pistaService.agendarUso();

        assertEquals("", resultado);
    }
}
