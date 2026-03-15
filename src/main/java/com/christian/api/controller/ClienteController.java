package com.christian.api.controller;

import com.christian.api.model.Cliente;
import org.springframework.web.bind.annotation.PostMapping;
import com.christian.api.service.ClienteService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }
    @PostMapping
    public Cliente criaCliente(@RequestBody Cliente cliente){
        return service.criaCliente(cliente) ;
    }

    @GetMapping
    public List<Cliente> listaCliente(){
        return service.listaClientes() ;
    }

    @GetMapping("/{id}")
    public Cliente listaClientePorId(@PathVariable Long id){
        return service.listaClientesPorId(id) ;
    }

    @DeleteMapping("/{id}")
    public void deletaCliente(@PathVariable Long id){
         service.deletaCliente(id); ;
    }
}
