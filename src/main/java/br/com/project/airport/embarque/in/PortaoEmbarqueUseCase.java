package br.com.project.airport.embarque.in;

import br.com.project.airport.embarque.model.PortaoEmbarque;

import java.util.List;

public interface PortaoEmbarqueUseCase {
    PortaoEmbarque salvar(PortaoEmbarque portao);
    List<PortaoEmbarque> listar();
    PortaoEmbarque buscarPorId(Long id);
    PortaoEmbarque atualizar(Long id, PortaoEmbarque portao);
    void deletar(Long id);
}
