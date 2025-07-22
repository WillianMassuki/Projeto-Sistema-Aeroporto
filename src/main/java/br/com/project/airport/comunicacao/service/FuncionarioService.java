package br.com.project.airport.comunicacao.service;

import br.com.project.airport.comunicacao.in.FuncionarioUseCase;
import br.com.project.airport.comunicacao.model.Funcionario;
import br.com.project.airport.comunicacao.out.FuncionarioRepositoryOutPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService implements FuncionarioUseCase {

    private final FuncionarioRepositoryOutPort repository;

    public FuncionarioService(FuncionarioRepositoryOutPort repository) {
        this.repository = repository;
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {
        return repository.salvar(funcionario);
    }

    @Override
    public Optional<Funcionario> buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    @Override
    public List<Funcionario> listar() {
        return repository.buscarTodos();
    }


    @Override
    public Funcionario atualizar(Long id, Funcionario funcionario) {
        Optional<Funcionario> existente = repository.buscarPorId(id);
        if (existente.isPresent()) {
            Funcionario atualizado = existente.get();
            atualizado.setNome(funcionario.getNome());
            atualizado.setCargo(funcionario.getCargo());
            atualizado.setMatricula(funcionario.getMatricula());
            return repository.salvar(atualizado);
        } else {
            throw new RuntimeException("Funcionario não encontrado");
        }
    }

    @Override
    public void deletar(Long id) {
        repository.deletarPorId(id);
    }

}
