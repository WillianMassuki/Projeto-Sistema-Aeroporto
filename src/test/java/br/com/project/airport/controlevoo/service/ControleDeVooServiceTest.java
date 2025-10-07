package br.com.project.airport.controlevoo.service;

import br.com.project.airport.controlevoo.model.ControleDeVoo;
import br.com.project.airport.controlevoo.out.ControladorVooRepositoryPort;
import br.com.project.airport.controlevoo.repository.ControladorVooJPARepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ControleDeVooServiceTest {


    private ControladorVooJPARepository repository;
    private ControladorVooRepositoryPort service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(ControladorVooJPARepository.class);
        service = new ControleDeVooService(repository);
    }

    @Test
    void deveSalvarControleDeVoo() {
        // Arrange
        ControleDeVoo controle = new ControleDeVoo();
        controle.setIdControle(1L);

        when(repository.save(controle)).thenReturn(controle);

        // Act
        ControleDeVoo resultado = service.save(controle);

        // Assert
        assertNotNull(resultado);
        assertEquals(1L, resultado.getIdControle());
        verify(repository, times(1)).save(controle);
    }

    @Test
    void deveRetornarListaDeControlesDeVoo() {
        // Arrange
        ControleDeVoo controle1 = new ControleDeVoo();
        ControleDeVoo controle2 = new ControleDeVoo();

        when(repository.findAll()).thenReturn(Arrays.asList(controle1, controle2));

        // Act
        List<ControleDeVoo> resultado = service.findAll();

        // Assert
        assertEquals(2, resultado.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void deveDeletarControleDeVooPorId() {
        // Arrange
        Long id = 42L;
        doNothing().when(repository).deleteById(id);

        // Act
        service.deleteById(id);

        // Assert
        verify(repository, times(1)).deleteById(id);
    }

}
