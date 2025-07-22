package br.com.project.airport.embarque.controller;

import br.com.project.airport.embarque.in.CartaoEmbarqueUseCase;
import br.com.project.airport.embarque.model.CartaoEmbarque;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoEmbarqueController {

    private final CartaoEmbarqueUseCase service;

    public CartaoEmbarqueController(CartaoEmbarqueUseCase service) {
        this.service = service;
    }

    @PostMapping
    public CartaoEmbarque salvar(@RequestBody CartaoEmbarque c) {
        return service.salvar(c);
    }

    @GetMapping
    public List<CartaoEmbarque> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public CartaoEmbarque buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public CartaoEmbarque atualizar(@PathVariable Long id, @RequestBody CartaoEmbarque c) {
        return service.atualizar(id, c);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
