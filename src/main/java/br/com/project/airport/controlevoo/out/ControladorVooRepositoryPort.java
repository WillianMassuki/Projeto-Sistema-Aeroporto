package br.com.project.airport.controlevoo.out;

import br.com.project.airport.controlevoo.model.ControleDeVoo;

import java.util.List;

public interface ControladorVooRepositoryPort {
    ControleDeVoo save(ControleDeVoo controleDeVoo);
//    Optional<ControleDeVoo> findById(Long id);
    List<ControleDeVoo> findAll();
    void deleteById(Long id);
}
