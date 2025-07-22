package br.com.project.airport.comunicacao.repository;

import br.com.project.airport.comunicacao.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioJpaRepository extends JpaRepository<Funcionario, Long>  {
}
