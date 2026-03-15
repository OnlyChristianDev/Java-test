package com.christian.api.service;

import com.christian.api.model.Produto;
import com.christian.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto criarProduto(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> listaProdutos() {
        return repository.findAll();
    }

    public Produto listaProdutoPorId(Long id) {
        Optional<Produto> produto = repository.findById(id);
        return produto.orElse(null);
    }

    public void deletaProduto(Long id) {
        repository.deleteById(id);
    }

}