package br.com.project.airport.controlevoo.adapter;

import br.com.project.airport.controlevoo.model.ControleDeVoo;
import br.com.project.airport.controlevoo.out.ControladorVooRepositoryPort;
import br.com.project.airport.controlevoo.repository.ControladorVooJPARepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ControladorVooRepositoryAdapter implements ControladorVooRepositoryPort {

    private final ControladorVooJPARepository controladorJpaRepository;

    public ControladorVooRepositoryAdapter(ControladorVooJPARepository controladorJpaRepository) {
        this.controladorJpaRepository = controladorJpaRepository;
    }


    @Override
    public ControleDeVoo save(ControleDeVoo controleDeVoo) {
        return controladorJpaRepository.save(controleDeVoo);
    }


    @Override
    public List<ControleDeVoo> findAll() {
        return controladorJpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        controladorJpaRepository.deleteById(id);

    }
}
