package com.lucas.cursomc.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.cursomc.Repositories.PedidoRepository;
import com.lucas.cursomc.Service.exeption.ObjectNotFoundException;
import com.lucas.cursomc.domain.Pedido;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		 
		Optional<Pedido> cat = repo.findById(id);
		
		return cat.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado" + id + "do Tipo," + Pedido.class.getName()));
	}
}