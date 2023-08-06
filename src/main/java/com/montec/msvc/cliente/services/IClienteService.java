package com.montec.msvc.cliente.services;

import com.montec.msvc.cliente.entities.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    public Cliente createClient(Cliente cliente);
    public List<Cliente> getAll();
    public ResponseEntity<Optional<Cliente>> getById(Long id);
    public ResponseEntity<Optional<Cliente>> getByEmail(String email);

    public ResponseEntity deleteById(Long id);
}
