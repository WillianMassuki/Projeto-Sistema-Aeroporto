package br.com.project.airport.embarque.controller;

import br.com.project.airport.embarque.in.BagagemUseCase;
import br.com.project.airport.embarque.model.Bagagem;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bagagens")
public class BagagemController {

    private final BagagemUseCase service;

    public BagagemController(BagagemUseCase service) {
        this.service = service;
    }

    @PostMapping
    public Bagagem salvar(@RequestBody Bagagem bagagem) {
        return service.salvar(bagagem);
    }

    @GetMapping
    public List<Bagagem> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Bagagem buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Bagagem atualizar(@PathVariable Long id, @RequestBody Bagagem bagagem) {
        return service.atualizar(id, bagagem);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}