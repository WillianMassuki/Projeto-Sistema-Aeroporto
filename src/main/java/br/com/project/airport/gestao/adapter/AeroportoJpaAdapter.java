package br.com.project.airport.gestao.adapter;

import br.com.project.airport.gestao.model.Aeroporto;
import br.com.project.airport.gestao.out.AeroportoRepositoryPort;
import br.com.project.airport.gestao.repository.AeroportoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AeroportoJpaAdapter implements AeroportoRepositoryPort {

    private final AeroportoJpaRepository repo;

    public AeroportoJpaAdapter(AeroportoJpaRepository repo) {
        this.repo = repo;
    }


    public Aeroporto salvar(Aeroporto a) {
        return repo.save(a);
    }

    public List<Aeroporto> listar() {
        return repo.findAll();
    }

    public Optional<Aeroporto> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
