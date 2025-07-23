package br.com.project.airport.gestaorecurso.repository;

import br.com.project.airport.gestaorecurso.model.VeiculoApoio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface veiculoRepository extends JpaRepository<VeiculoApoio, String> {
}
