package br.com.project.airport.gestaorecurso.in;

import br.com.project.airport.gestaorecurso.model.Recurso;

import java.util.List;

public interface RecursoUseCase {

    Recurso criar(Recurso recurso);
    Recurso buscarPorId(String id);
    List<Recurso> listarTodos();
    void deletar(String id);
    Recurso alocar(String id);
    Recurso liberar(String id);
}
