package br.com.project.airport.comunicacao.in;

import br.com.project.airport.comunicacao.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioUseCase {

    Funcionario criar(Funcionario funcionario);
    Optional<Funcionario> buscarPorId(Long id);
    List<Funcionario> listar();
    Funcionario atualizar(Long id, Funcionario funcionario);
    void deletar(Long id);
}
