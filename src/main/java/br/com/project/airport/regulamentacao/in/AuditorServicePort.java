package br.com.project.airport.regulamentacao.in;

import br.com.project.airport.regulamentacao.model.Auditor;

import java.util.List;
import java.util.Optional;

public interface AuditorServicePort {
    Auditor adicionarAuditor(Auditor auditor);
    Optional<Auditor> buscarAuditorPorId(Long id);
    List<Auditor> listarTodosAuditores();
    Auditor atualizarDadosAuditor(Long id, Auditor auditor);
    void removerAuditor(Long id);
}
