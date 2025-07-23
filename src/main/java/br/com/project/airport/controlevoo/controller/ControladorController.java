package br.com.project.airport.controlevoo.controller;

import br.com.project.airport.controlevoo.in.ControladorUseCase;
import br.com.project.airport.controlevoo.model.Controlador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controladores")
public class ControladorController {

    private final ControladorUseCase service;

    public ControladorController(ControladorUseCase service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Controlador> create(@RequestBody Controlador controlador) {
        return ResponseEntity.ok(service.create(controlador));
    }


    @GetMapping
    public ResponseEntity<List<Controlador>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Controlador> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Controlador> update(@PathVariable Long id, @RequestBody Controlador controlador) {
        return ResponseEntity.ok(service.update(id, controlador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
