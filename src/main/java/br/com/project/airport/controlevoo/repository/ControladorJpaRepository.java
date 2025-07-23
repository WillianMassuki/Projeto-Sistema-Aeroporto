package br.com.project.airport.controlevoo.repository;

import br.com.project.airport.controlevoo.model.Controlador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControladorJpaRepository extends JpaRepository<Controlador, Long> {
}
