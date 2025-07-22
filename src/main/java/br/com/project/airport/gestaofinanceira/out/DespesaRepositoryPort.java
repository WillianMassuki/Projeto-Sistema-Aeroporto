package br.com.project.airport.gestaofinanceira.out;

import br.com.project.airport.gestaofinanceira.model.Despesa;

import java.util.List;
import java.util.Optional;

public interface DespesaRepositoryPort {
    Despesa salvar(Despesa despesa);
    List<Despesa> listar();
    Optional<Despesa> buscarPorId(Long id);
    void deletar(Long id);
}

