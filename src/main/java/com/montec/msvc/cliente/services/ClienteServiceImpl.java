package com.montec.msvc.cliente.services;

import com.montec.msvc.cliente.dao.ClienteDao;
import com.montec.msvc.cliente.entities.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteServiceImpl implements IClienteService{

    private ClienteDao clienteDao;

    public ClienteServiceImpl(ClienteDao clienteDao){
        this.clienteDao = clienteDao;
    }

    @Override
    public Cliente createClient(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public List<Cliente> getAll() {
        return clienteDao.findAll();
    }

    @Override
    public ResponseEntity<Optional<Cliente>> getById(Long id) {
        if(clienteDao.findById(id).isPresent()) {
            return ResponseEntity.ok().body(clienteDao.findById(id));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Optional<Cliente>> getByEmail(String email) {
        if(clienteDao.findByEmail(email).isPresent()){
            return ResponseEntity.ok().body(clienteDao.findByEmail(email));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        if(clienteDao.findById(id).isPresent()) {
            clienteDao.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
