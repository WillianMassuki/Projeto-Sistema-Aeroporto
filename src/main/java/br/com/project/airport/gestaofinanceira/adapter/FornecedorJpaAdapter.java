package br.com.project.airport.gestaofinanceira.adapter;

import br.com.project.airport.gestaofinanceira.model.Fornecedor;
import br.com.project.airport.gestaofinanceira.out.FornecedorRepositoryPort;
import br.com.project.airport.gestaofinanceira.repository.FornecedorJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FornecedorJpaAdapter implements FornecedorRepositoryPort {

    private final FornecedorJpaRepository repo;

    public FornecedorJpaAdapter(FornecedorJpaRepository repo) {
        this.repo = repo;
    }

    public Fornecedor salvar(Fornecedor f) {
        return  repo.save(f);
    }

    public List<Fornecedor> listar() {
        return repo.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
