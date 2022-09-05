package com.lucas.cursomc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
