package br.com.project.airport.regulamentacao.service;

import br.com.project.airport.regulamentacao.model.Auditor;
import br.com.project.airport.regulamentacao.out.AuditorRepositoryPort;
import br.com.project.airport.regulamentacao.repository.AuditorRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditorService implements AuditorRepositoryPort {

    private final AuditorRepositoryJpa auditorRepositoryJpa;

    public AuditorService(AuditorRepositoryJpa auditorRepositoryJpa) {
        this.auditorRepositoryJpa = auditorRepositoryJpa;
    }

    @Override
    public Auditor salvar(Auditor auditor) {
        return auditorRepositoryJpa.save(auditor);
    }

    @Override
    public Optional<Auditor> buscarPorId(Long id) {
        return auditorRepositoryJpa.findById(id);
    }

    @Override
    public List<Auditor> buscarTodas() {
        return auditorRepositoryJpa.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        auditorRepositoryJpa.findById(id);

    }

}

 /*
    public  String realizarInspecao(EntidadeRegulada entidade)
    {

        return "";
    }

     */