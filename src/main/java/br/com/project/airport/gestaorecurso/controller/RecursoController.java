package br.com.project.airport.gestaorecurso.controller;

import br.com.project.airport.gestaorecurso.model.Recurso;
import br.com.project.airport.gestaorecurso.service.RecursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

    private final RecursoService service;

    public RecursoController(RecursoService service) {
        this.service = service;
    }

    @PostMapping
    public Recurso criar(@RequestBody Recurso recurso) {
        return service.criar(recurso);
    }

    @GetMapping("/{id}")
    public Recurso buscar(@PathVariable String id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<Recurso> listar() {
        return service.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }

    @PostMapping("/{id}/alocar")
    public Recurso alocar(@PathVariable String id) {
        return service.alocar(id);
    }

    @PostMapping("/{id}/liberar")
    public Recurso liberar(@PathVariable String id) {
        return service.liberar(id);
    }
}
