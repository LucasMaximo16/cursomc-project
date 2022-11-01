package com.lucas.cursomc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.cursomc.domain.Categoria;
import com.lucas.cursomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
