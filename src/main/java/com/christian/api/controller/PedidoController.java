package com.christian.api.controller;

import com.christian.api.model.Pedido;
import com.christian.api.service.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public Pedido criaPedido(@RequestBody Pedido pedido){
        return service.criaPedido(pedido);
    }
}
