package br.com.project.airport.gestaorecurso.repository;

import br.com.project.airport.gestaorecurso.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepositoryJPA extends JpaRepository<Recurso, String> {}
