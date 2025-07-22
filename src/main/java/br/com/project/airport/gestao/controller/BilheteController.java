package br.com.project.airport.gestao.controller;

import br.com.project.airport.gestao.in.BilheteUseCase;
import br.com.project.airport.gestao.model.Bilhete;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bilhetes")
public class BilheteController {

    private final BilheteUseCase service;

    public BilheteController(BilheteUseCase service) {
        this.service = service;
    }

    @PostMapping
    public Bilhete salvar(@RequestBody Bilhete b) {
        return service.salvar(b);
    }

    @GetMapping
    public List<Bilhete> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Bilhete buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Bilhete atualizar(@PathVariable Long id, @RequestBody Bilhete b) {
        return service.atualizar(id, b);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
