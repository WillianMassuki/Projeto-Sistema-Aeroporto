package br.com.project.airport.embarque.out;

import br.com.project.airport.embarque.model.CartaoEmbarque;

import java.util.List;
import java.util.Optional;

public interface CartaoEmbarqueRepositoryPort {
    CartaoEmbarque salvar(CartaoEmbarque cartao);
    List<CartaoEmbarque> listar();
    Optional<CartaoEmbarque> buscarPorId(Long id);
    void deletar(Long id);
}
