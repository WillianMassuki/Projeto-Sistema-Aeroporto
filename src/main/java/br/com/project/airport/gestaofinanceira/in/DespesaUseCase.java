package br.com.project.airport.gestaofinanceira.in;

import br.com.project.airport.gestaofinanceira.model.Despesa;

import java.util.List;

public interface DespesaUseCase {
    Despesa salvar(Despesa despesa);
    List<Despesa> listar();
    Despesa buscarPorId(Long id);
    Despesa atualizar(Long id, Despesa despesa);
    void deletar(Long id);
}