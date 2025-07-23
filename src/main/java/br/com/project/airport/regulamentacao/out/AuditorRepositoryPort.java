package br.com.project.airport.regulamentacao.out;

import br.com.project.airport.regulamentacao.model.Auditor;

import java.util.List;
import java.util.Optional;

public interface AuditorRepositoryPort {
    Auditor salvar(Auditor auditor);
    Optional<Auditor> buscarPorId(Long id);
    List<Auditor> buscarTodas();
    void deletarPorId(Long id);
}
