package com.barbershopteno.barbershop.service;

import com.barbershopteno.barbershop.entity.Cliente;
import com.barbershopteno.barbershop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente cliente){
        return repository.save(cliente);
    }

    public Cliente buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

}
