package br.com.project.airport.controlevoo.service;

import br.com.project.airport.controlevoo.in.ControladorUseCase;
import br.com.project.airport.controlevoo.model.Controlador;
import br.com.project.airport.controlevoo.out.ControladorRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControladorService implements ControladorUseCase {

    private final ControladorRepositoryPort repository;

    public ControladorService(ControladorRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Controlador create(Controlador controlador) {
        return repository.save(controlador);
    }

    @Override
    public Controlador update(Long id, Controlador controlador) {
        Controlador existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Controlador não encontrado"));

        existente.setNome(controlador.getNome());
        existente.setMatricula(controlador.getMatricula());

        return repository.save(existente);
    }

    @Override
    public Controlador getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Controlador não encontrado"));
    }

    @Override
    public List<Controlador> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Void monitorarVoo() {
        return null;
    }

}
