package br.com.project.airport.gestaofinanceira.controller;

import br.com.project.airport.gestaofinanceira.in.DespesaUseCase;
import br.com.project.airport.gestaofinanceira.model.Despesa;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaUseCase service;

    public DespesaController(DespesaUseCase service) {
        this.service = service;
    }

    @PostMapping
    public Despesa salvar(@RequestBody Despesa d) {
        return service.salvar(d);
    }

    @GetMapping
    public List<Despesa> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Despesa buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Despesa atualizar(@PathVariable Long id, @RequestBody Despesa d) {
        return service.atualizar(id, d);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
