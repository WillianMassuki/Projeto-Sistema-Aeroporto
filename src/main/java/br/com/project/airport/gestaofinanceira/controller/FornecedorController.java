package br.com.project.airport.gestaofinanceira.controller;

import br.com.project.airport.gestaofinanceira.model.Fornecedor;
import br.com.project.airport.gestaofinanceira.service.FornecedorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    public Fornecedor salvar(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.salvar(fornecedor);
    }

    @GetMapping
    public List<Fornecedor> listar() {
        return fornecedorService.listar();
    }

    @GetMapping("/{id}")
    public Fornecedor buscar(@PathVariable Long id) {
        return fornecedorService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Fornecedor atualizar(@PathVariable Long id, @RequestBody Fornecedor b) {
        return fornecedorService.atualizar(id, b);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        fornecedorService.deletar(id);
    }
}