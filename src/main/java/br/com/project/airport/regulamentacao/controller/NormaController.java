package br.com.project.airport.regulamentacao.controller;

import br.com.project.airport.regulamentacao.model.Norma;
import br.com.project.airport.regulamentacao.out.NormaRepositoryPort;
import br.com.project.airport.regulamentacao.repository.NormaRepositoryJpa;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/norma")
public class NormaController implements NormaRepositoryPort {

    private final NormaRepositoryJpa repositoryJpa;

    public NormaController(NormaRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }


    @Override
    public Norma salvar(Norma norma) {
        return repositoryJpa.save(norma);
    }

    @Override
    public Optional<Norma> buscarPorId(Long id) {
        return repositoryJpa.findById(id);
    }

    @Override
    public List<Norma> buscarTodas() {
        return repositoryJpa.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        repositoryJpa.deleteById(id);

    }
}
