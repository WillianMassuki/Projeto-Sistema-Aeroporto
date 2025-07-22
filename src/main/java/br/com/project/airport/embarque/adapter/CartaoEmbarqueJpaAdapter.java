package br.com.project.airport.embarque.adapter;

import br.com.project.airport.embarque.model.CartaoEmbarque;
import br.com.project.airport.embarque.out.CartaoEmbarqueRepositoryPort;
import br.com.project.airport.embarque.repository.CartaoEmbarqueRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CartaoEmbarqueJpaAdapter implements CartaoEmbarqueRepositoryPort {

    private final CartaoEmbarqueRepository repo;

    public CartaoEmbarqueJpaAdapter(CartaoEmbarqueRepository repo) {
        this.repo = repo;
    }


    public CartaoEmbarque salvar(CartaoEmbarque c) {
        return repo.save(c);
    }

    public List<CartaoEmbarque> listar() {
        return repo.findAll();
    }

    public Optional<CartaoEmbarque> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}