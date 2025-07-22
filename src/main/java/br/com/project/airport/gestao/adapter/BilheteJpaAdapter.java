package br.com.project.airport.gestao.adapter;

import br.com.project.airport.gestao.model.Bilhete;
import br.com.project.airport.gestao.out.BilheteRepositoryPort;
import br.com.project.airport.gestao.repository.BilheteJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BilheteJpaAdapter implements BilheteRepositoryPort {

    private final BilheteJpaRepository repo;

    public BilheteJpaAdapter(BilheteJpaRepository repo) {
        this.repo = repo;
    }


    public Bilhete salvar(Bilhete b) {
        return repo.save(b);
    }

    public List<Bilhete> listar() {
        return repo.findAll();
    }

    public Optional<Bilhete> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}

