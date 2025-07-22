package br.com.project.airport.gestao.repository;

import br.com.project.airport.gestao.model.Bilhete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilheteJpaRepository extends JpaRepository<Bilhete, Long> {}

