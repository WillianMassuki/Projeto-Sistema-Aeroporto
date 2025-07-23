package br.com.project.airport.embarque.service;

import br.com.project.airport.embarque.in.PortaoEmbarqueUseCase;
import br.com.project.airport.embarque.model.PortaoEmbarque;
import br.com.project.airport.embarque.repository.PortaoEmbarqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortaoEmbarqueService implements PortaoEmbarqueUseCase {

    private final PortaoEmbarqueRepository repository;

    public PortaoEmbarqueService(PortaoEmbarqueRepository repository) {
        this.repository = repository;
    }

    @Override
    public PortaoEmbarque salvar(PortaoEmbarque portao) {
        return null;
    }

    @Override
    public List<PortaoEmbarque> listar() {
        return List.of();
    }

    @Override
    public PortaoEmbarque buscarPorId(Long id) {
        return null;
    }

    @Override
    public PortaoEmbarque atualizar(Long id, PortaoEmbarque portao) {
        return null;
    }

    @Override
    public void deletar(Long id) {

    }

    /*

    public PortaoEmbarqueService(PortaoEmbarqueRepositoryPort repository) {
        this.repository = repository;
    }

    public PortaoEmbarque salvar(PortaoEmbarque portao) {
        return repository.salvar(portao);
    }

    public List<PortaoEmbarque> listar() {
        return repository.findAll();

    public PortaoEmbarque buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portão não encontrado"));
    }

    public PortaoEmbarque atualizar(Long id, PortaoEmbarque novo) {
        PortaoEmbarque atual = buscarPorId(id);
        atual.setIdPortao(novo.getIdPortao());
        return repository.salvar(atual);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

     */
}