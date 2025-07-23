package br.com.project.airport.regulamentacao.in;

import br.com.project.airport.gestaorecurso.model.Pista;
import br.com.project.airport.regulamentacao.model.Norma;

import java.util.List;
import java.util.Optional;

public interface NormaServicePort {
    Norma criarNorma(Norma norma);
    Optional<Norma> buscarPorId(Long id);
    List<Norma> listarTodasNorma();
    Pista atualizarNorma(Long id, Norma norma);
    void deletarNorma(Long id);
}
