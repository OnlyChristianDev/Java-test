package com.christian.api.service;

import com.christian.api.repository.PedidoRepository;
import com.christian.api.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido criaPedido(Pedido pedido) {
        return repository.save(pedido);
    }

    public Pedido listaPedidoPorId(Long id) {
        Optional<Pedido> pedido = repository.findById(id);
        return pedido.orElse(null);
    }

    public List<Pedido> listaPedido() {
        return repository.findAll();
    }

    public void deletaPedido(Long id) {
        repository.deleteById(id);
    }
}
