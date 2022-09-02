package com.lucas.cursomc.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.cursomc.domain.Categoria;
import com.lucas.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{


}
