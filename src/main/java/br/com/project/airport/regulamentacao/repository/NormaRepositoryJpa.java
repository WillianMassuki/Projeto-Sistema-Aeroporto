package br.com.project.airport.regulamentacao.repository;

import br.com.project.airport.regulamentacao.model.Norma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormaRepositoryJpa extends JpaRepository<Norma, Long> {
}
