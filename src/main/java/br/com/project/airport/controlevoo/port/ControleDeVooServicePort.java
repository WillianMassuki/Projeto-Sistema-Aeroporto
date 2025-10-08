package br.com.project.airport.controlevoo.port;

import br.com.project.airport.controlevoo.model.ControleDeVoo;

import java.util.List;

public interface ControleDeVooServicePort {
    default ControleDeVoo criarControle(ControleDeVoo controle) {
        return null;
    }

    default ControleDeVoo atualizarControle(Long id, ControleDeVoo controle) {
        return null;
    }

    ControleDeVoo buscarPorId(Long id);

    default List<ControleDeVoo> listarTodos() {
        return null;
    }

    void deletar(Long id);
}