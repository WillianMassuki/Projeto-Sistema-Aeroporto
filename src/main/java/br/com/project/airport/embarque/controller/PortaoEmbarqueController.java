package br.com.project.airport.embarque.controller;

import br.com.project.airport.embarque.in.PortaoEmbarqueUseCase;
import br.com.project.airport.embarque.model.PortaoEmbarque;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portoes")
public class PortaoEmbarqueController {

    private final PortaoEmbarqueUseCase service;

    public PortaoEmbarqueController(PortaoEmbarqueUseCase service) {
        this.service = service;
    }

    @PostMapping
    public PortaoEmbarque salvar(@RequestBody PortaoEmbarque p) {
        return service.salvar(p);
    }

    @GetMapping
    public List<PortaoEmbarque> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PortaoEmbarque buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public PortaoEmbarque atualizar(@PathVariable Long id, @RequestBody PortaoEmbarque p) {
        return service.atualizar(id, p);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
