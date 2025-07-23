package br.com.project.airport.controlevoo.adapter;

import br.com.project.airport.embarque.model.PortaoEmbarque;
import br.com.project.airport.embarque.out.PortaoEmbarqueRepositoryPort;
import br.com.project.airport.embarque.repository.PortaoEmbarqueRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PortaoEmbarqueJpaAdapter implements PortaoEmbarqueRepositoryPort {

    private final PortaoEmbarqueRepository repo;

    public PortaoEmbarqueJpaAdapter(PortaoEmbarqueRepository repo) {
        this.repo = repo;
    }

    public PortaoEmbarque salvar(PortaoEmbarque p) {
        return repo.save(p);
    }

    public List<PortaoEmbarque> listar() {
        return repo.findAll();
    }

    public Optional<PortaoEmbarque> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}