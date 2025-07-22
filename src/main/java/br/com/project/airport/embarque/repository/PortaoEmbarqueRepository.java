package br.com.project.airport.embarque.repository;

import br.com.project.airport.embarque.model.PortaoEmbarque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortaoEmbarqueRepository extends JpaRepository<PortaoEmbarque, Long> {
}
