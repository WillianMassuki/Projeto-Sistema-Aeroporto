package br.com.project.airport.comunicacao.repository;

import br.com.project.airport.comunicacao.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemJpaRepository extends JpaRepository<Mensagem, String> {
}