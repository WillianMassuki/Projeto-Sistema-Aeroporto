package br.com.project.airport.embarque.repository;

import br.com.project.airport.embarque.model.CartaoEmbarque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoEmbarqueRepository extends JpaRepository<CartaoEmbarque, Long> {
}
