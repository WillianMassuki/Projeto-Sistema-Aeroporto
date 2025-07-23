package br.com.project.airport.gestaorecurso.adapter;

import br.com.project.airport.gestaorecurso.model.Recurso;
import br.com.project.airport.gestaorecurso.out.RecursoRepositoryPort;
import br.com.project.airport.gestaorecurso.repository.RecursoRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RecursoAdapter implements RecursoRepositoryPort {

    private final RecursoRepositoryJPA recursoRepositoryJPA;

    public RecursoAdapter(RecursoRepositoryJPA recursoRepositoryJPA) {
        this.recursoRepositoryJPA = recursoRepositoryJPA;
    }

    @Override
    public Recurso salvar(Recurso recurso) {
        return recursoRepositoryJPA.save(recurso);
    }

    @Override
    public Optional<Recurso> buscarPorId(String id) {
        return recursoRepositoryJPA.findById(id);
    }

    @Override
    public List<Recurso> buscarTodos() {
        return recursoRepositoryJPA.findAll();
    }

    @Override
    public void deletar(String id) {

        recursoRepositoryJPA.deleteById(id);

    }
}
