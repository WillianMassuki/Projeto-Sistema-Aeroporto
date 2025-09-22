package br.com.project.airport.embarque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortaoEmbarqueRepository extends JpaRepository<PortaoEmbarque, Long> {
}
