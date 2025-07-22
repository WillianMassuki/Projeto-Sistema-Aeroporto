package br.com.project.airport.gestaofinanceira.out;

import br.com.project.airport.gestaofinanceira.model.Fornecedor;

import java.util.List;
import java.util.Optional;

public interface FornecedorRepositoryPort {
    Fornecedor salvar(Fornecedor fornecedor);
    List<Fornecedor> listar();
    Optional<Fornecedor> buscarPorId(Long id);
    void deletar(Long id);

}
