package br.com.project.airport.controlevoo.adapter;

import br.com.project.airport.controlevoo.model.Controlador;
import br.com.project.airport.controlevoo.out.ControladorRepositoryPort;
import br.com.project.airport.controlevoo.repository.ControladorJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ControladorRepositoryAdapter implements ControladorRepositoryPort {

    private final ControladorJpaRepository controladorJpaRepository;

    public ControladorRepositoryAdapter(ControladorJpaRepository controladorJpaRepository) {
        this.controladorJpaRepository = controladorJpaRepository;
    }


    @Override
    public Controlador save(Controlador controlador) {
        return controladorJpaRepository.save(controlador);
    }

    @Override
    public Optional<Controlador> findById(Long id) {
        return controladorJpaRepository.findById(id);
    }

    @Override
    public List<Controlador> findAll() {
        return controladorJpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        controladorJpaRepository.deleteById(id);

    }
}
