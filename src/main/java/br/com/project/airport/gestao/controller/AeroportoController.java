package br.com.project.airport.gestao.controller;

import br.com.project.airport.gestao.in.AeroportoUseCase;
import br.com.project.airport.gestao.model.Aeroporto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {

    private final AeroportoUseCase service;

    public AeroportoController(AeroportoUseCase service) {
        this.service = service;
    }

    @PostMapping
    public Aeroporto salvar(@RequestBody Aeroporto a) {
        return service.salvar(a);
    }

    @GetMapping
    public List<Aeroporto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Aeroporto buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Aeroporto atualizar(@PathVariable Long id, @RequestBody Aeroporto a) {
        return service.atualizar(id, a);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
