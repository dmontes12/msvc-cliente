package com.montec.msvc.cliente.controllers;


import com.montec.msvc.cliente.entities.Cliente;
import com.montec.msvc.cliente.services.IClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v0/cliente")
public class ClienteController {


    private IClienteService clienteService;

    public ClienteController(IClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Map<String,List<Cliente>>> getAllClients(){
        return ResponseEntity.ok().body(Collections.singletonMap("Clientes",clienteService.getAll()));
    }

    @GetMapping("/email")
    public ResponseEntity<Optional<Cliente>> getClientByEmail(@RequestParam String value){
        return clienteService.getByEmail(value);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> getClientById(@PathVariable Long id){
        return clienteService.getById(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
      return clienteService.deleteById(id);
    }


    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok().body(clienteService.createClient(cliente));
    }


}
