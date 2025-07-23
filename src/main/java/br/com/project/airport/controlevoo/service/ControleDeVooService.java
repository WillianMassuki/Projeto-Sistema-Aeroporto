package br.com.project.airport.controlevoo.service;

import br.com.project.airport.controlevoo.model.ControleDeVoo;
import br.com.project.airport.controlevoo.out.ControladorVooRepositoryPort;
import br.com.project.airport.controlevoo.repository.ControladorVooJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControleDeVooService implements ControladorVooRepositoryPort {

    private final ControladorVooJPARepository repository;


    public ControleDeVooService(ControladorVooJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public ControleDeVoo save(ControleDeVoo controleDeVoo) {
        return repository.save(controleDeVoo);
    }

    @Override
    public List<ControleDeVoo> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {

        repository.deleteById(id);

    }
}