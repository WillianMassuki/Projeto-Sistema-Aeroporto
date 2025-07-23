package br.com.project.airport.regulamentacao.adapter;

import br.com.project.airport.gestaorecurso.model.Pista;
import br.com.project.airport.regulamentacao.in.NormaServicePort;
import br.com.project.airport.regulamentacao.model.Norma;
import br.com.project.airport.regulamentacao.repository.NormaRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NormaRepositoryAdapter implements NormaServicePort {


    private final NormaRepositoryJpa repositoryJpa;


    public NormaRepositoryAdapter(NormaRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public Norma criarNorma(Norma norma) {
        return null;
    }

    @Override
    public Optional<Norma> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Norma> listarTodasNorma() {
        return List.of();
    }

    @Override
    public Pista atualizarNorma(Long id, Norma norma) {
        return null;
    }

    @Override
    public void deletarNorma(Long id) {

    }
}
