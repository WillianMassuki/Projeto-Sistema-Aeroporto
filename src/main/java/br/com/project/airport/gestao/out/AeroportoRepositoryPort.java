package br.com.project.airport.gestao.out;

import br.com.project.airport.gestao.model.Aeroporto;

import java.util.List;
import java.util.Optional;

public interface AeroportoRepositoryPort {
    Aeroporto salvar(Aeroporto aeroporto);
    List<Aeroporto> listar();
    Optional<Aeroporto> buscarPorId(Long id);
    void deletar(Long id);
}
