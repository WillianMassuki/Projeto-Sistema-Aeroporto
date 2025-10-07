package br.com.project.airport.gestaofinanceira.service;

import br.com.project.airport.gestaofinanceira.model.Despesa;
import br.com.project.airport.gestaofinanceira.out.DespesaRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DespesaServiceTest {

    @Mock
    private DespesaRepositoryPort repository;

    @InjectMocks
    private DespesaService service;

    private Despesa despesa;

    @BeforeEach
    void setUp() {
        despesa = new Despesa();
        despesa.setIdDespesa(1L);
        despesa.setDescricao("Aluguel");
        despesa.setValor(new BigDecimal("1200.00"));
        despesa.setData(LocalDate.of(2025, 1, 10).atStartOfDay());
        despesa.setCategoria("Moradia");
    }

    @Test
    void deveSalvarDespesa() {
        when(repository.salvar(despesa)).thenReturn(despesa);

        Despesa resultado = service.salvar(despesa);

        assertNotNull(resultado);
        assertEquals("Aluguel", resultado.getDescricao());
        verify(repository, times(1)).salvar(despesa);
    }

    @Test
    void deveListarDespesas() {
        when(repository.listar()).thenReturn(Arrays.asList(despesa));

        List<Despesa> resultado = service.listar();

        assertEquals(1, resultado.size());
        assertEquals("Aluguel", resultado.get(0).getDescricao());
        verify(repository, times(1)).listar();
    }

    @Test
    void deveBuscarPorIdQuandoExistir() {
        when(repository.buscarPorId(1L)).thenReturn(Optional.of(despesa));

        Despesa resultado = service.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getIdDespesa());
        verify(repository, times(1)).buscarPorId(1L);
    }

    @Test
    void deveLancarExcecaoAoBuscarPorIdInexistente() {
        when(repository.buscarPorId(99L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.buscarPorId(99L);
        });

        assertEquals("Despesa não encontrada", exception.getMessage());
        verify(repository, times(1)).buscarPorId(99L);
    }

    @Test
    void deveAtualizarDespesa() {
        Despesa nova = new Despesa();
        nova.setDescricao("Mercado");
        nova.setValor(new BigDecimal("500.00"));
        nova.setData(LocalDate.of(2025, 2, 15).atStartOfDay());
        nova.setCategoria("Alimentação");

        when(repository.buscarPorId(1L)).thenReturn(Optional.of(despesa));
        when(repository.salvar(any(Despesa.class))).thenReturn(despesa);

        Despesa resultado = service.atualizar(1L, nova);

        assertEquals("Mercado", despesa.getDescricao());
        assertEquals(new BigDecimal("500.00"), despesa.getValor());
        assertEquals("Alimentação", despesa.getCategoria());
        verify(repository, times(1)).buscarPorId(1L);
        verify(repository, times(1)).salvar(despesa);
    }

    @Test
    void deveDeletarDespesa() {
        doNothing().when(repository).deletar(1L);

        service.deletar(1L);

        verify(repository, times(1)).deletar(1L);
    }
}