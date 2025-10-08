package br.com.project.airport.controlevoo.port;

import br.com.project.airport.controlevoo.model.ControleDeVoo;

import java.util.List;
import java.util.Optional;

public interface ControleDeVooRepositoryPort {
    ControleDeVoo save(ControleDeVoo controle);
    Optional<ControleDeVoo> findById(Long id);
    List<ControleDeVoo> findAll();
    void deleteById(Long id);
}