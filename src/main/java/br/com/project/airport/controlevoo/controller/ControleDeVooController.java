package br.com.project.airport.controlevoo.controller;

import br.com.project.airport.controlevoo.model.ControleDeVoo;
import br.com.project.airport.controlevoo.port.ControleDeVooServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controleDeVoo")
public class ControleDeVooController {

    private final ControleDeVooServicePort service;

    public ControleDeVooController(ControleDeVooServicePort service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ControleDeVoo> criar(@RequestBody ControleDeVoo controle) {
        return ResponseEntity.ok(service.criarControle(controle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ControleDeVoo> atualizar(@PathVariable Long id, @RequestBody ControleDeVoo controle) {
        return ResponseEntity.ok(service.atualizarControle(id, controle));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ControleDeVoo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ControleDeVoo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}