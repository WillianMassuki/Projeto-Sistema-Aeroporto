package br.com.project.airport.controlevoo.out;

import br.com.project.airport.controlevoo.model.TorreDeControle;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TorreDeControleRepository {
    TorreDeControle save(TorreDeControle torre);
    Optional<TorreDeControle> findById(Long id);
    List<TorreDeControle> findAll();
    void deleteById(Long id);
}
