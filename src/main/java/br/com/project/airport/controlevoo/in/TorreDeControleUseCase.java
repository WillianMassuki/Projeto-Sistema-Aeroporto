package br.com.project.airport.controlevoo.in;

import br.com.project.airport.controlevoo.model.TorreDeControle;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface TorreDeControleUseCase {


    TorreDeControle create(TorreDeControle torreDeControle);

  //  TorreDeControle update(Long id, TorreDeControle torreDeControle);

    Optional<TorreDeControle> getById(Long id);


    List<TorreDeControle> getAll();

    void delete(Long id);
}
