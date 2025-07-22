package br.com.project.airport.gestaofinanceira.controller;

import br.com.project.airport.gestaofinanceira.in.FornecedorUseCase;
import br.com.project.airport.gestaofinanceira.model.Fornecedor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorUseCase service;

    public FornecedorController(FornecedorUseCase service) {
        this.service = service;
    }

    @PostMapping
    public Fornecedor salvar(@RequestBody Fornecedor f) {
        return service.salvar(f);
    }

    @GetMapping
    public List<Fornecedor> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Fornecedor buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Fornecedor atualizar(@PathVariable Long id, @RequestBody Fornecedor f) {
        return service.atualizar(id, f);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}