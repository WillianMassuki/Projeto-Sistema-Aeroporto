package br.com.project.airport.regulamentacao.service;

import br.com.project.airport.regulamentacao.model.Aeronave;
import br.com.project.airport.regulamentacao.out.AeronaveRepositoryPort;
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
class AeronaveServiceTest {

    @Mock
    private AeronaveRepositoryPort aeronaveRepositoryPort;

    @InjectMocks
    private AeronaveService aeronaveService;

    private Aeronave aeronave;

    @BeforeEach
    void setUp() {
        aeronave = new Aeronave();
        aeronave.setCodigoAeronave(1L);
        aeronave.setModelo("Boeing 737");
    }

    @Test
    void salvar_deveChamarRepositoryESalvarAeronave() {
        when(aeronaveRepositoryPort.salvar(aeronave)).thenReturn(aeronave);

        Aeronave resultado = aeronaveService.salvar(aeronave);

        assertNotNull(resultado);
        assertEquals("Boeing 737", resultado.getModelo());
        verify(aeronaveRepositoryPort).salvar(aeronave);
    }

    @Test
    void buscarPorId_deveRetornarAeronaveQuandoExistir() {
        when(aeronaveRepositoryPort.buscarPorId(1L)).thenReturn(Optional.of(aeronave));

        Optional<Aeronave> resultado = aeronaveService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Boeing 737", resultado.get().getModelo());
        verify(aeronaveRepositoryPort).buscarPorId(1L);
    }

    @Test
    void buscarPorId_deveRetornarEmptyQuandoNaoExistir() {
        when(aeronaveRepositoryPort.buscarPorId(999L)).thenReturn(Optional.empty());

        Optional<Aeronave> resultado = aeronaveService.buscarPorId(999L);

        assertTrue(resultado.isEmpty());
        verify(aeronaveRepositoryPort).buscarPorId(999L);
    }

    @Test
    void buscarTodas_deveRetornarListaDeAeronaves() {
        List<Aeronave> lista = Arrays.asList(aeronave, new Aeronave());
        when(aeronaveRepositoryPort.buscarTodas()).thenReturn(lista);

        List<Aeronave> resultado = aeronaveService.buscarTodas();

        assertEquals(2, resultado.size());
        verify(aeronaveRepositoryPort).buscarTodas();
    }

    @Test
    void deletarPorId_deveChamarRepository() {
        doNothing().when(aeronaveRepositoryPort).deletarPorId(1L);

        aeronaveService.deletarPorId(1L);

        verify(aeronaveRepositoryPort).deletarPorId(1L);
    }

    @Test
    void enviarDados_deveRetornarMensagemEsperada() {
        String resultado = aeronaveService.enviarDados();

        assertEquals("nada de dados", resultado);
    }

    @Test
    void verificarDisponibilidade_deveRetornarStringVazia() {
        String resultado = aeronaveService.verificarDisponibilidade();

        assertEquals("", resultado);
    }
}