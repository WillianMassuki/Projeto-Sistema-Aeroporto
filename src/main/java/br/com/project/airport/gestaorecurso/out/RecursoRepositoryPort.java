package br.com.project.airport.gestaorecurso.out;

import br.com.project.airport.gestaorecurso.model.Recurso;

import java.util.List;
import java.util.Optional;

public interface RecursoRepositoryPort {

    Recurso salvar(Recurso recurso);
    Optional<Recurso> buscarPorId(String id);
    List<Recurso> buscarTodos();
    void deletar(String id);
}
