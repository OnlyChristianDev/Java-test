package com.christian.api.service;

import com.christian.api.model.Produto;
import com.christian.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import com.christian.api.model.Cliente;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente criaCliente(Cliente cliente){
        return repository.save(cliente);
    }

    public List<Cliente> listaClientes(){
        return repository.findAll();
    }

    public Cliente listaClientesPorId(Long id){
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElse(null);
    }

    public void deletaCliente(Long id){
        repository.deleteById(id);
    }
}
