package br.com.project.airport.controlevoo.in;

import br.com.project.airport.controlevoo.model.ControleDeVoo;

import java.util.List;

public interface ControleDeVooUseCase {


    ControleDeVoo create(ControleDeVoo controleDeVoo);

    ControleDeVoo update(Long id, ControleDeVoo controleDeVoo);

    ControleDeVoo getById(Long id);

    List<ControleDeVoo> getAll();

    void delete(Long id);
}
