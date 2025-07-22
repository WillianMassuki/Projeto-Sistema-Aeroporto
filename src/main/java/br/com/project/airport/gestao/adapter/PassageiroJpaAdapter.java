package br.com.project.airport.gestao.adapter;

import br.com.project.airport.gestao.model.Passageiro;
import br.com.project.airport.gestao.out.PassageiroRepositoryPort;
import br.com.project.airport.gestao.repository.PassageiroJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassageiroJpaAdapter implements PassageiroRepositoryPort {

    private final PassageiroJpaRepository repo;

    public PassageiroJpaAdapter(PassageiroJpaRepository repo) {
        this.repo = repo;
    }


    public Passageiro salvar(Passageiro p) {
        return  repo.save(p);
    }

    public List<Passageiro> listar() {
        return repo.findAll();
    }

    @Override
    public Passageiro buscarPorId(Long id) {
        return null;
    }

 /*   public Passageiro buscarPorId(Long id) {
        return repo.findById(id);
    }

  */

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
