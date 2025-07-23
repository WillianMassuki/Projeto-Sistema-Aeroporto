package br.com.project.airport.regulamentacao.repository;

import br.com.project.airport.regulamentacao.model.CompanhiaAerea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanhiaAereaRepositoryJpa extends JpaRepository<CompanhiaAerea, Long> {
}
