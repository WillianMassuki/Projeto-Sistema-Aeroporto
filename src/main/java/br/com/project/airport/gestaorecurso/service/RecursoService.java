package br.com.project.airport.gestaorecurso.service;

import br.com.project.airport.gestaorecurso.in.RecursoUseCase;
import br.com.project.airport.gestaorecurso.model.Recurso;
import br.com.project.airport.gestaorecurso.out.RecursoRepositoryPort;

import java.util.List;

public class RecursoService implements RecursoUseCase {

    private final RecursoRepositoryPort repository;

    public RecursoService(RecursoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Recurso criar(Recurso recurso) {
        return repository.salvar(recurso);
    }

    @Override
    public Recurso buscarPorId(String id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
    }

    @Override
    public List<Recurso> listarTodos() {
        return repository.buscarTodos();
    }

    @Override
    public void deletar(String id) {
        repository.deletar(id);
    }

    @Override
    public Recurso alocar(String id) {
        Recurso recurso = buscarPorId(id);
        recurso.alocar();
        return repository.salvar(recurso);
    }

    @Override
    public Recurso liberar(String id) {
        Recurso recurso = buscarPorId(id);
        recurso.liberar();
        return repository.salvar(recurso);
    }
}