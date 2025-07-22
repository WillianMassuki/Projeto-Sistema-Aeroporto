package br.com.project.airport.gestaofinanceira.repository;

import br.com.project.airport.gestaofinanceira.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaJpaRepository extends JpaRepository<Despesa, Long> {}

