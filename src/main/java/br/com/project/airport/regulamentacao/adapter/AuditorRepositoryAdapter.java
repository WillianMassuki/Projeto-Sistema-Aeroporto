package br.com.project.airport.regulamentacao.adapter;

import br.com.project.airport.regulamentacao.model.Auditor;
import br.com.project.airport.regulamentacao.out.AuditorRepositoryPort;
import br.com.project.airport.regulamentacao.repository.AuditorRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuditorRepositoryAdapter implements AuditorRepositoryPort {

    private final AuditorRepositoryJpa repositoryJpa;

    public AuditorRepositoryAdapter(AuditorRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public Auditor salvar(Auditor auditor) {
        return repositoryJpa.save(auditor);
    }

    @Override
    public Optional<Auditor> buscarPorId(Long id) {
        return repositoryJpa.findById(id);
    }

    @Override
    public List<Auditor> buscarTodas() {
        return repositoryJpa.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        repositoryJpa.deleteById(id);

    }
}