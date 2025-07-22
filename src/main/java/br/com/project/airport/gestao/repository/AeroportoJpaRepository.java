package br.com.project.airport.gestao.repository;

import br.com.project.airport.gestao.model.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeroportoJpaRepository extends JpaRepository<Aeroporto, Long> {}

