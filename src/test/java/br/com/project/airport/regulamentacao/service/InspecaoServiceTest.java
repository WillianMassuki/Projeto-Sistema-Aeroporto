package br.com.project.airport.regulamentacao.service;

import br.com.project.airport.regulamentacao.model.Inspecao;
import br.com.project.airport.regulamentacao.repository.InspecaoRepositoryJpa;
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
class InspecaoServiceTest {

    @Mock
    private InspecaoRepositoryJpa inspecaoRepositoryJpa;

    @InjectMocks
    private InspecaoService inspecaoService;

    private Inspecao inspecao;

    @BeforeEach
    void setUp() {
        inspecao = new Inspecao();
        inspecao.setCodigoInspecao(1L);
        inspecao.setObservacoes("Inspeção de qualidade");
    }

    @Test
    void deveSalvarInspecaoComSucesso() {
        when(inspecaoRepositoryJpa.save(inspecao)).thenReturn(inspecao);

        Inspecao resultado = inspecaoService.salvar(inspecao);

        assertNotNull(resultado);
        assertEquals(inspecao.getCodigoInspecao(), resultado.getCodigoInspecao());
        verify(inspecaoRepositoryJpa, times(1)).save(inspecao);
    }

    @Test
    void deveBuscarInspecaoPorId() {
        when(inspecaoRepositoryJpa.findById(1L)).thenReturn(Optional.of(inspecao));

        Optional<Inspecao> resultado = inspecaoService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Inspeção de qualidade", resultado.get().getObservacoes());
        verify(inspecaoRepositoryJpa, times(1)).findById(1L);
    }

    @Test
    void deveRetornarListaDeInspecoes() {
        Inspecao outra = new Inspecao();
        outra.setCodigoInspecao(2L);
        outra.setObservacoes("Inspeção final");

        List<Inspecao> lista = Arrays.asList(inspecao, outra);

        when(inspecaoRepositoryJpa.findAll()).thenReturn(lista);

        List<Inspecao> resultado = inspecaoService.buscarTodas();

        assertEquals(2, resultado.size());
        verify(inspecaoRepositoryJpa, times(1)).findAll();
    }

    @Test
    void deveDeletarInspecaoPorId() {
        doNothing().when(inspecaoRepositoryJpa).deleteById(1L);

        inspecaoService.deletarPorId(1L);

        verify(inspecaoRepositoryJpa, times(1)).deleteById(1L);
    }

    @Test
    void deveRetornarOptionalVazioQuandoNaoEncontrarInspecao() {
        when(inspecaoRepositoryJpa.findById(99L)).thenReturn(Optional.empty());

        Optional<Inspecao> resultado = inspecaoService.buscarPorId(99L);

        assertTrue(resultado.isEmpty());
        verify(inspecaoRepositoryJpa, times(1)).findById(99L);
    }
}