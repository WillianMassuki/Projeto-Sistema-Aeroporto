package br.com.project.airport.comunicacao.adapter;

import br.com.project.airport.comunicacao.model.Funcionario;
import br.com.project.airport.comunicacao.out.FuncionarioRepositoryOutPort;
import br.com.project.airport.comunicacao.repository.FuncionarioJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FuncionarioRepositoryAdapter implements FuncionarioRepositoryOutPort {

    private final FuncionarioJpaRepository jpaRepository;

    public FuncionarioRepositoryAdapter(FuncionarioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Funcionario salvar(Funcionario funcionario) {
        return jpaRepository.save(funcionario);
    }

    @Override
    public Optional<Funcionario> buscarPorId(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        jpaRepository.deleteById(id);
    }
}
