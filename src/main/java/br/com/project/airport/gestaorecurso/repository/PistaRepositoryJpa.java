package br.com.project.airport.gestaorecurso.repository;

import br.com.project.airport.gestaorecurso.model.Pista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PistaRepositoryJpa extends JpaRepository<Pista, Long> {
}
