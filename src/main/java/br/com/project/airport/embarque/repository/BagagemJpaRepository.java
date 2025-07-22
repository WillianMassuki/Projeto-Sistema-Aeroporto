package br.com.project.airport.embarque.repository;

import br.com.project.airport.embarque.model.Bagagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagagemJpaRepository extends JpaRepository<Bagagem, Long> {}
