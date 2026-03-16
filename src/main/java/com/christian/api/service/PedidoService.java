package com.christian.api.service;

import com.christian.api.exception.ResourceNotFoundException;
import com.christian.api.repository.PedidoRepository;
import com.christian.api.model.Pedido;
import org.springframework.stereotype.Service;
import com.christian.api.repository.ClienteRepository;
import com.christian.api.repository.ProdutoRepository;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoService(
            PedidoRepository repository,
            ClienteRepository clienteRepository,
            ProdutoRepository produtoRepository
    ) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }


    public Pedido criaPedido(Pedido pedido) {

        if (!clienteRepository.existsById(pedido.getClienteId())) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }

        if (!produtoRepository.existsById(pedido.getProdutoId())) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        return repository.save(pedido);
    }

    public Pedido listaPedidoPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
    }

    public List<Pedido> listaPedido() {
        return repository.findAll();
    }

    public void deletaPedido(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Pedido não encontrado");
        }
        repository.deleteById(id);
    }
}
