package br.com.project.airport.controlevoo.repository;


import br.com.project.airport.controlevoo.model.TorreDeControle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorreDeControleJpaRepository extends JpaRepository<TorreDeControle, Long> {}
