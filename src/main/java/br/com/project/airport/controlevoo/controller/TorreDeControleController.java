// adapter/inbound/controller/TorreDeControleController.java
package br.com.project.airport.controlevoo.controller;

import br.com.project.airport.controlevoo.model.TorreDeControle;
import br.com.project.airport.controlevoo.service.TorreControleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/torres")
public class TorreDeControleController {

    private final TorreControleService service;

    public TorreDeControleController(TorreControleService torreDeControleUseCase) {
        this.service = torreDeControleUseCase;
    }


    @PostMapping
    public ResponseEntity<TorreDeControle> criar(@RequestBody TorreDeControle torre) {
        return ResponseEntity.ok(service.create(torre));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TorreDeControle> buscarPorId(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public List<TorreDeControle> listar() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
