package br.com.project.airport.controlevoo.in;

import br.com.project.airport.controlevoo.model.Controlador;

import java.util.List;

public interface ControladorUseCase {

    Controlador create(Controlador controlador);
    Controlador update(Long id, Controlador controlador);
    Controlador getById(Long id);
    List<Controlador> getAll();
    void delete(Long id);
}
