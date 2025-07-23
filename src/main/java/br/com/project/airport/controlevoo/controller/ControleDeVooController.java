package br.com.project.airport.controlevoo.controller;

import br.com.project.airport.controlevoo.model.ControleDeVoo;
import br.com.project.airport.controlevoo.service.ControleDeVooService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controleDeVoo")
public class ControleDeVooController {

    private final ControleDeVooService service;

    public ControleDeVooController(ControleDeVooService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ControleDeVoo> criar(@RequestBody ControleDeVoo controle) {
        return ResponseEntity.ok(service.save(controle));
    }


    @GetMapping
    public List<ControleDeVoo> listar() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}