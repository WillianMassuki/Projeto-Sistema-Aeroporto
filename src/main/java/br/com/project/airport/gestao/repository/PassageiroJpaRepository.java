package br.com.project.airport.gestao.repository;

import br.com.project.airport.gestao.model.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassageiroJpaRepository extends JpaRepository<Passageiro, Long> {}
