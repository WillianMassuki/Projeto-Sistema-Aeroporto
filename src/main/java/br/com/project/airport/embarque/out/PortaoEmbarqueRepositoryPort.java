package br.com.project.airport.embarque.out;

import java.util.List;
import java.util.Optional;

public interface PortaoEmbarqueRepositoryPort {
    PortaoEmbarque salvar(PortaoEmbarque portao);
    List<PortaoEmbarque> listar();
    Optional<PortaoEmbarque> buscarPorId(Long id);
    void deletar(Long id);
}
