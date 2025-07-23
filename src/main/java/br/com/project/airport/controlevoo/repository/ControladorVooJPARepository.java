package br.com.project.airport.controlevoo.repository;

import br.com.project.airport.controlevoo.model.ControleDeVoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControladorVooJPARepository extends JpaRepository<ControleDeVoo, Long> {
}
