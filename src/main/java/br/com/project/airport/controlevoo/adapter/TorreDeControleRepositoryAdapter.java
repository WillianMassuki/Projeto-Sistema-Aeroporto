package br.com.project.airport.controlevoo.adapter;

import br.com.project.airport.controlevoo.model.TorreDeControle;
import br.com.project.airport.controlevoo.repository.TorreDeControleJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TorreDeControleRepositoryAdapter {
    private final TorreDeControleJpaRepository repository;

    public TorreDeControleRepositoryAdapter(TorreDeControleJpaRepository repository) {
        this.repository = repository;
    }


    public TorreDeControle criarTorre(TorreDeControle torre) {
        return repository.save(torre);
    }

    public Optional<TorreDeControle> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<TorreDeControle> listarTodas() {
        return repository.findAll();
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}
