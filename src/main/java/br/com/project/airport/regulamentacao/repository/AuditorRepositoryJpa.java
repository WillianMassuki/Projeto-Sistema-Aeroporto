package br.com.project.airport.regulamentacao.repository;

import br.com.project.airport.regulamentacao.model.Auditor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditorRepositoryJpa extends JpaRepository<Auditor, Long> {
}
