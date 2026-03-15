package com.christian.api.controller;

import com.christian.api.model.Produto;
import com.christian.api.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return service.criarProduto(produto);
    }

    @GetMapping
    public List<Produto> listaProdutos() {
        return service.listaProdutos();
    }

    @GetMapping("/{id}")
    public Produto listaProdutosPorId(@PathVariable Long id) {
        return service.listaProdutoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void listaProdutos(@PathVariable Long id) {
        service.deletaProduto(id);
    }
}