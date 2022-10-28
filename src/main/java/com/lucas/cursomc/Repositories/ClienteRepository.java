package com.lucas.cursomc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
