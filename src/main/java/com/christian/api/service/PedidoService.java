package com.christian.api.service;

import com.christian.api.repository.PedidoRepository;
import com.christian.api.model.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido criaPedido(Pedido pedido) {
        return repository.save(pedido);
    }
}
