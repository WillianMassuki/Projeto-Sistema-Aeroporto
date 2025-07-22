package br.com.project.airport.gestao.in;

import br.com.project.airport.gestao.model.Aeroporto;

import java.util.List;

public interface AeroportoUseCase {
    Aeroporto salvar(Aeroporto aeroporto);

    List<Aeroporto> listar();

    Aeroporto buscarPorId(Long id);

    Aeroporto atualizar(Long id, Aeroporto aeroporto);

    void deletar(Long id);
}