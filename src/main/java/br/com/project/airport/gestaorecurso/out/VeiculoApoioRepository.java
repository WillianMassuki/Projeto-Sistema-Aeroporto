package br.com.project.airport.gestaorecurso.out;

import br.com.project.airport.gestaorecurso.model.VeiculoApoio;

import java.util.List;
import java.util.Optional;

public interface VeiculoApoioRepository {
    VeiculoApoio save(VeiculoApoio veiculo);
    Optional<VeiculoApoio> findByPlaca(String placa);
    List<VeiculoApoio> findAll();
    void deleteByPlaca(String placa);
}
