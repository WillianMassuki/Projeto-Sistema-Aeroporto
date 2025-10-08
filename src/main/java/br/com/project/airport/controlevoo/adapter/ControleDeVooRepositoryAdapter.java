package br.com.project.airport.controlevoo.adapter;

import br.com.project.airport.controlevoo.model.ControleDeVoo;
import br.com.project.airport.controlevoo.port.ControleDeVooRepositoryPort;
import br.com.project.airport.controlevoo.repository.ControladorVooJPARepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ControleDeVooRepositoryAdapter implements ControleDeVooRepositoryPort {

    private final ControladorVooJPARepository jpaRepository;

    public ControleDeVooRepositoryAdapter(ControladorVooJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ControleDeVoo save(ControleDeVoo controle) {
        return jpaRepository.save(controle);
    }

    @Override
    public Optional<ControleDeVoo> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<ControleDeVoo> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}