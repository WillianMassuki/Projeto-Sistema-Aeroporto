package br.com.project.airport.controlevoo.out;

import br.com.project.airport.controlevoo.model.Controlador;

import java.util.List;
import java.util.Optional;

public interface ControladorRepositoryPort {

    Controlador save(Controlador controlador);
    Optional<Controlador> findById(Long id);
    List<Controlador> findAll();
    void deleteById(Long id);
}
