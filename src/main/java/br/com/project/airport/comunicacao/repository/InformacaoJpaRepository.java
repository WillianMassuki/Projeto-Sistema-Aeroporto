package br.com.project.airport.comunicacao.repository;

import br.com.project.airport.comunicacao.model.Informacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacaoJpaRepository extends JpaRepository<Informacao, String> {
}