package br.com.project.airport.regulamentacao.service;


import br.com.project.airport.regulamentacao.model.Norma;
import br.com.project.airport.regulamentacao.repository.NormaRepositoryJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NormaServiceTest {

    @Mock
    private NormaRepositoryJpa normaRepositoryJpa;

    @InjectMocks
    private NormaService normaService;

    private Norma norma;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        norma = new Norma();
        norma.setCodigoNorma("1");
        norma.setDescricao("Norma ISO 9001");
    }

    @Test
    void deveSalvarNormaComSucesso() {
        when(normaRepositoryJpa.save(norma)).thenReturn(norma);

        Norma resultado = normaService.salvar(norma);

        assertNotNull(resultado);
        assertEquals(norma.getCodigoNorma(), resultado.getCodigoNorma());
        verify(normaRepositoryJpa, times(1)).save(norma);
    }

    @Test
    void deveBuscarNormaPorIdExistente() {
        when(normaRepositoryJpa.findById(1L)).thenReturn(Optional.of(norma));

        Optional<Norma> resultado = normaService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals(norma.getCodigoNorma(), resultado.get().getCodigoNorma());
        verify(normaRepositoryJpa, times(1)).findById(1L);
    }

    @Test
    void deveRetornarVazioAoBuscarPorIdInexistente() {
        when(normaRepositoryJpa.findById(99L)).thenReturn(Optional.empty());

        Optional<Norma> resultado = normaService.buscarPorId(99L);

        assertFalse(resultado.isPresent());
        verify(normaRepositoryJpa, times(1)).findById(99L);
    }

    @Test
    void deveBuscarTodasAsNormas() {
        List<Norma> listaNormas = Arrays.asList(norma, new Norma());
        when(normaRepositoryJpa.findAll()).thenReturn(listaNormas);

        List<Norma> resultado = normaService.buscarTodas();

        assertEquals(2, resultado.size());
        verify(normaRepositoryJpa, times(1)).findAll();
    }

    @Test
    void deveDeletarNormaPorId() {
        doNothing().when(normaRepositoryJpa).deleteById(1L);

        normaService.deletarPorId(1L);

        verify(normaRepositoryJpa, times(1)).deleteById(1L);
    }
}