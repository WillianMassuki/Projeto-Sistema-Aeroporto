package br.com.project.airport.regulamentacao.service;

import br.com.project.airport.regulamentacao.model.Auditor;
import br.com.project.airport.regulamentacao.repository.AuditorRepositoryJpa;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuditorServiceTest {

    @Mock
    private AuditorRepositoryJpa auditorRepositoryJpa;

    @InjectMocks
    private AuditorService auditorService;

    private Auditor auditor;

    @BeforeEach
    void setUp() {
        auditor = new Auditor();
        auditor.setCodigoAuditor(1L);
        auditor.setNome("Carlos Auditor");
    }

    @Test
    void salvar_deveSalvarAuditorComSucesso() {
        when(auditorRepositoryJpa.save(auditor)).thenReturn(auditor);

        Auditor resultado = auditorService.salvar(auditor);

        assertNotNull(resultado);
        assertEquals("Carlos Auditor", resultado.getNome());
        verify(auditorRepositoryJpa).save(auditor);
    }

    @Test
    void buscarPorId_deveRetornarAuditorQuandoExistir() {
        when(auditorRepositoryJpa.findById(1L)).thenReturn(Optional.of(auditor));

        Optional<Auditor> resultado = auditorService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Carlos Auditor", resultado.get().getNome());
        verify(auditorRepositoryJpa).findById(1L);
    }

    @Test
    void buscarPorId_deveRetornarEmptyQuandoNaoExistir() {
        when(auditorRepositoryJpa.findById(99L)).thenReturn(Optional.empty());

        Optional<Auditor> resultado = auditorService.buscarPorId(99L);

        assertTrue(resultado.isEmpty());
        verify(auditorRepositoryJpa).findById(99L);
    }

    @Test
    void buscarTodas_deveRetornarListaDeAuditores() {
        List<Auditor> lista = Arrays.asList(auditor, new Auditor());
        when(auditorRepositoryJpa.findAll()).thenReturn(lista);

        List<Auditor> resultado = auditorService.buscarTodas();

        assertEquals(2, resultado.size());
        verify(auditorRepositoryJpa).findAll();
    }

    @Test
    void deletarPorId_deveChamarFindById() {
        when(auditorRepositoryJpa.findById(1L)).thenReturn(Optional.of(auditor));

        auditorService.deletarPorId(1L);

        verify(auditorRepositoryJpa).findById(1L);
    }
}