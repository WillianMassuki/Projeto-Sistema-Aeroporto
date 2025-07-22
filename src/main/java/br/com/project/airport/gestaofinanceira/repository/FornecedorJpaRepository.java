package br.com.project.airport.gestaofinanceira.repository;

import br.com.project.airport.gestaofinanceira.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorJpaRepository extends JpaRepository<Fornecedor, Long> {}

