package com.christian.api.controller;

import com.christian.api.model.Pedido;
import com.christian.api.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public Pedido criaPedido(@RequestBody Pedido pedido){
        return service.criaPedido(pedido);
    }

    @GetMapping("/{id}")
    public Pedido listaPedidoPorId(@PathVariable Long id){
        return service.listaPedidoPorId(id);
    }

    @GetMapping
    public List<Pedido> listaPedido(){
        return service.listaPedido();
    }

    @DeleteMapping("/{id}")
    public void deletaPedido(@PathVariable Long id){

        service.deletaPedido(id);
    }
}
