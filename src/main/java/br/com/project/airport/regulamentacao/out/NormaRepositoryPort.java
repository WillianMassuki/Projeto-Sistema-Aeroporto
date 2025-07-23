package br.com.project.airport.regulamentacao.out;

import br.com.project.airport.regulamentacao.model.Norma;

import java.util.List;
import java.util.Optional;

public interface NormaRepositoryPort {
    Norma salvar(Norma norma);
    Optional<Norma> buscarPorId(Long id);
    List<Norma> buscarTodas();
    void deletarPorId(Long id);
}
