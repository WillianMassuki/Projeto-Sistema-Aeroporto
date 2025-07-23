package br.com.project.airport.controlevoo.service;

import br.com.project.airport.controlevoo.in.TorreDeControleUseCase;
import br.com.project.airport.controlevoo.model.TorreDeControle;
import br.com.project.airport.controlevoo.repository.TorreDeControleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TorreControleService implements TorreDeControleUseCase {

    private final TorreDeControleJpaRepository repository;

    public TorreControleService(TorreDeControleJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public TorreDeControle create(TorreDeControle torreDeControle) {
        return repository.save(torreDeControle);
    }

    /*
    @Override
    public TorreDeControle update(Long id, TorreDeControle torreDeControle) {
        TorreDeControle existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Controlador não encontrado"));

        existente.setLocalizacao(torreDeControle.getLocalizacao());

        return repository.save(existente);
    }

     */

    @Override
    public Optional<TorreDeControle> getById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Controlador não encontrado")));
    }

    @Override
    public List<TorreDeControle> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    public String autorizarDecolagem() {
        return "";
    }

    public String autorizarPouso() {
        return "";
    }
}
