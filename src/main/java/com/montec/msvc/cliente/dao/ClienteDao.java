package com.montec.msvc.cliente.dao;

import com.montec.msvc.cliente.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteDao extends JpaRepository<Cliente,Long> {
    public Optional<Cliente> findByEmail(String email);
}
