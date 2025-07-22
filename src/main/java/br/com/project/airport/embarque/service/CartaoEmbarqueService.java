package br.com.project.airport.embarque.service;

import br.com.project.airport.embarque.in.CartaoEmbarqueUseCase;
import br.com.project.airport.embarque.model.CartaoEmbarque;
import br.com.project.airport.embarque.out.CartaoEmbarqueRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoEmbarqueService implements CartaoEmbarqueUseCase {

    private final CartaoEmbarqueRepositoryPort repository;

    public CartaoEmbarqueService(CartaoEmbarqueRepositoryPort repository) {
        this.repository = repository;
    }

    public CartaoEmbarque salvar(CartaoEmbarque cartao) {
        return repository.salvar(cartao);
    }

    public List<CartaoEmbarque> listar() {
        return repository.listar();
    }

    public CartaoEmbarque buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
    }

    public CartaoEmbarque atualizar(Long id, CartaoEmbarque novo) {
        CartaoEmbarque atual = buscarPorId(id);
        atual.setCodigoCartaoEmbarque(novo.getCodigoCartaoEmbarque());
        atual.setAssento(novo.getAssento());
        return repository.salvar(atual);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }
}