package br.com.project.airport.gestaofinanceira.adapter;

import br.com.project.airport.gestaofinanceira.model.Despesa;
import br.com.project.airport.gestaofinanceira.out.DespesaRepositoryPort;
import br.com.project.airport.gestaofinanceira.repository.DespesaJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DespesaJpaAdapter implements DespesaRepositoryPort {

    private final DespesaJpaRepository repo;

    public DespesaJpaAdapter(DespesaJpaRepository repo) {
        this.repo = repo;
    }
    public Despesa salvar(Despesa d) {
        return repo.save(d);
    }

    public List<Despesa> listar() {
        return repo.findAll();
    }

    public Optional<Despesa> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
