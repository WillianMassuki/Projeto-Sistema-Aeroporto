package br.com.project.airport.regulamentacao.service;

import br.com.project.airport.regulamentacao.model.Norma;
import br.com.project.airport.regulamentacao.out.NormaRepositoryPort;
import br.com.project.airport.regulamentacao.repository.NormaRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NormaService implements NormaRepositoryPort {

    private final NormaRepositoryJpa normaRepositoryJpa;

    public NormaService(NormaRepositoryJpa normaRepositoryJpa) {
        this.normaRepositoryJpa = normaRepositoryJpa;
    }


    @Override
    public Norma salvar(Norma norma) {
        return normaRepositoryJpa.save(norma);
    }

    @Override
    public Optional<Norma> buscarPorId(Long id) {
        return normaRepositoryJpa.findById(id);
    }

    @Override
    public List<Norma> buscarTodas() {
        return normaRepositoryJpa.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        normaRepositoryJpa.deleteById(id);

    }
}
