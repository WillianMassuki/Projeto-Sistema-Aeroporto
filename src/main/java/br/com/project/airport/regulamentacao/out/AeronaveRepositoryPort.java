package br.com.project.airport.regulamentacao.out;

import br.com.project.airport.regulamentacao.model.Aeronave;

import java.util.List;
import java.util.Optional;

public interface AeronaveRepositoryPort {
    Aeronave salvar(Aeronave aeronave);
    Optional<Aeronave> buscarPorId(Long id);
    List<Aeronave> buscarTodas();
    void deletarPorId(Long id);
}
