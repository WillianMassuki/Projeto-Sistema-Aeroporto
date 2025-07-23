package br.com.project.airport.regulamentacao.repository;

import br.com.project.airport.regulamentacao.model.Inspecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspecaoRepositoryJpa extends JpaRepository<Inspecao, Long> {
}
