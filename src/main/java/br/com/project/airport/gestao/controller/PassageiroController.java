package br.com.project.airport.gestao.controller;

import br.com.project.airport.gestao.in.PassageiroUseCase;
import br.com.project.airport.gestao.model.Passageiro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    private final PassageiroUseCase service;

    public PassageiroController(PassageiroUseCase service) {
        this.service = service;
    }

    @PostMapping
    public Passageiro salvar(@RequestBody Passageiro p) {
        return service.salvar(p);
    }

    @GetMapping
    public List<Passageiro> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Passageiro buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Passageiro atualizar(@PathVariable Long id, @RequestBody Passageiro p) {
        return service.atualizar(id, p);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
