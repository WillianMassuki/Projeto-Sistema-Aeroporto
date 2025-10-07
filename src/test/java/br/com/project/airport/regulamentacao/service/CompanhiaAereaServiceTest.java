package br.com.project.airport.regulamentacao.service;

import br.com.project.airport.regulamentacao.model.CompanhiaAerea;
import br.com.project.airport.regulamentacao.repository.CompanhiaAereaRepositoryJpa;
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
class CompanhiaAereaServiceTest {

    @Mock
    private CompanhiaAereaRepositoryJpa companhiaAereaRepositoryJpa;

    @InjectMocks
    private CompanhiaAereaService companhiaAereaService;

    private CompanhiaAerea companhiaAerea;

    @BeforeEach
    void setUp() {
        companhiaAerea = new CompanhiaAerea();
        companhiaAerea.setCodigoCompanhiaAerea(1L);
        companhiaAerea.setPaisOrigem("PulsR Airlines");
    }

    @Test
    void criarCompanhiaAerea_DeveSalvarEDevolverCompanhia() {
        when(companhiaAereaRepositoryJpa.save(companhiaAerea)).thenReturn(companhiaAerea);

        CompanhiaAerea resultado = companhiaAereaService.criarCompanhiaAerea(companhiaAerea);

        assertNotNull(resultado);
        assertEquals("PulsR Airlines", resultado.getPaisOrigem());
        verify(companhiaAereaRepositoryJpa, times(1)).save(companhiaAerea);
    }

    @Test
    void buscarPorId_DeveRetornarCompanhiaQuandoExistir() {
        when(companhiaAereaRepositoryJpa.findById(1L)).thenReturn(Optional.of(companhiaAerea));

        Optional<CompanhiaAerea> resultado = companhiaAereaService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("PulsR Airlines", resultado.get().getPaisOrigem());
        verify(companhiaAereaRepositoryJpa, times(1)).findById(1L);
    }

    @Test
    void buscarPorId_DeveRetornarVazioQuandoNaoExistir() {
        when(companhiaAereaRepositoryJpa.findById(99L)).thenReturn(Optional.empty());

        Optional<CompanhiaAerea> resultado = companhiaAereaService.buscarPorId(99L);

        assertTrue(resultado.isEmpty());
        verify(companhiaAereaRepositoryJpa, times(1)).findById(99L);
    }

    @Test
    void listarTodasCompanhias_DeveRetornarListaDeCompanhias() {
        CompanhiaAerea outra = new CompanhiaAerea();
        outra.setCodigoCompanhiaAerea(2L);
        outra.setPaisOrigem("Quantum Air");

        when(companhiaAereaRepositoryJpa.findAll()).thenReturn(Arrays.asList(companhiaAerea, outra));

        List<CompanhiaAerea> resultado = companhiaAereaService.listarTodasCompanhias();

        assertEquals(2, resultado.size());
        verify(companhiaAereaRepositoryJpa, times(1)).findAll();
    }

    @Test
    void deletarCompanhia_DeveChamarDeleteById() {
        doNothing().when(companhiaAereaRepositoryJpa).deleteById(1L);

        companhiaAereaService.deletarCompanhia(1L);

        verify(companhiaAereaRepositoryJpa, times(1)).deleteById(1L);
    }

    @Test
    void atualizarCompanhiaAerea_DeveRetornarNullPorEnquanto() {
        CompanhiaAerea resultado = companhiaAereaService.atualizarCompanhiaAerea(1L, companhiaAerea);
        assertNull(resultado, "Deveria retornar null até implementação futura");
    }
}