package br.com.project.airport.regulamentacao.repository;

import br.com.project.airport.regulamentacao.model.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeronaveRepositoryJpa extends JpaRepository<Aeronave, Long> {
}
