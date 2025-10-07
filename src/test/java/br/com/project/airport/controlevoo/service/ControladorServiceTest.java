package br.com.project.airport.controlevoo.service;

import br.com.project.airport.controlevoo.model.Controlador;
import br.com.project.airport.controlevoo.out.ControladorRepositoryPort;
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

public class ControladorServiceTest {


        @Mock
        private ControladorRepositoryPort repository;

        @InjectMocks
        private ControladorService service;

        private Controlador controlador;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
            controlador = new Controlador();
            controlador.setIdControlador(1L);
            controlador.setNome("João");
            controlador.setMatricula("ABC123");
        }

        @Test
        void deveCriarControlador() {
            when(repository.save(controlador)).thenReturn(controlador);

            Controlador result = service.create(controlador);

            assertNotNull(result);
            assertEquals("João", result.getNome());
            verify(repository, times(1)).save(controlador);
        }

        @Test
        void deveAtualizarControladorExistente() {
            Controlador novo = new Controlador();
            novo.setNome("Maria");
            novo.setMatricula("XYZ789");

            when(repository.findById(1L)).thenReturn(Optional.of(controlador));
            when(repository.save(any(Controlador.class))).thenAnswer(invocation -> invocation.getArgument(0));

            Controlador result = service.update(1L, novo);

            assertEquals("Maria", result.getNome());
            assertEquals("XYZ789", result.getMatricula());
            verify(repository).save(controlador);
        }

        @Test
        void deveLancarExcecaoAoAtualizarControladorInexistente() {
            when(repository.findById(99L)).thenReturn(Optional.empty());

            RuntimeException ex = assertThrows(RuntimeException.class,
                    () -> service.update(99L, controlador));

            assertEquals("Controlador não encontrado", ex.getMessage());
            verify(repository, never()).save(any());
        }

        @Test
        void deveBuscarControladorPorId() {
            when(repository.findById(1L)).thenReturn(Optional.of(controlador));

            Controlador result = service.getById(1L);

            assertEquals("João", result.getNome());
            verify(repository).findById(1L);
        }

        @Test
        void deveLancarExcecaoAoBuscarInexistente() {
            when(repository.findById(1L)).thenReturn(Optional.empty());

            assertThrows(RuntimeException.class, () -> service.getById(1L));
        }

        @Test
        void deveRetornarTodosOsControladores() {
            when(repository.findAll()).thenReturn(Arrays.asList(controlador));

            List<Controlador> result = service.getAll();

            assertEquals(1, result.size());
            verify(repository).findAll();
        }

        @Test
        void deveDeletarControlador() {
            doNothing().when(repository).deleteById(1L);

            service.delete(1L);

            verify(repository).deleteById(1L);
        }

        @Test
        void deveRetornarNuloAoMonitorarVoo() {
            assertNull(service.monitorarVoo());
        }
}
