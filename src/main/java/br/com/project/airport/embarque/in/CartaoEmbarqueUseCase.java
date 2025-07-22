package br.com.project.airport.embarque.in;

import br.com.project.airport.embarque.model.CartaoEmbarque;

import java.util.List;

public interface CartaoEmbarqueUseCase {
    CartaoEmbarque salvar(CartaoEmbarque cartao);
    List<CartaoEmbarque> listar();
    CartaoEmbarque buscarPorId(Long id);
    CartaoEmbarque atualizar(Long id, CartaoEmbarque cartao);
    void deletar(Long id);
}
