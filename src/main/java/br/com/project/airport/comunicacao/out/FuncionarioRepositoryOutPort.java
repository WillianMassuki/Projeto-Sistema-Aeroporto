package br.com.project.airport.comunicacao.out;

import br.com.project.airport.comunicacao.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepositoryOutPort {

    Funcionario salvar(Funcionario funcionario);
    Optional<Funcionario> buscarPorId(Long id);
    List<Funcionario> buscarTodos();
    void deletarPorId(Long id);
}
