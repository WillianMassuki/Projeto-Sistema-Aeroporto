package br.com.project.airport.gestaofinanceira.in;

import br.com.project.airport.gestaofinanceira.model.Fornecedor;

import java.util.List;

public interface FornecedorUseCase {
    Fornecedor salvar(Fornecedor fornecedor);
    List<Fornecedor> listar();
    Fornecedor buscarPorId(Long id);
    Fornecedor atualizar(Long id, Fornecedor fornecedor);
    void deletar(Long id);
}
