package br.com.project.airport.gestaorecurso.adapter;

import br.com.project.airport.gestaorecurso.model.Pista;
import br.com.project.airport.gestaorecurso.out.PistaRepositoryPort;
import br.com.project.airport.gestaorecurso.repository.PistaRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PistaRepositoryAdapter implements PistaRepositoryPort {

    private final PistaRepositoryJpa repositoryJpa;

    public PistaRepositoryAdapter(PistaRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public Pista salvar(Pista pista) {

        return repositoryJpa.save(pista);
    }

    @Override
    public Optional<Pista> buscarPorId(Long id) {
        return repositoryJpa.findById(id);
    }

    @Override
    public List<Pista> buscarTodas() {
        return repositoryJpa.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        repositoryJpa.deleteById(id);
    }

}