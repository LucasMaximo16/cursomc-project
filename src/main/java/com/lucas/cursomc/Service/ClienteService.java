package com.lucas.cursomc.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.cursomc.Repositories.ClienteRepository;
import com.lucas.cursomc.Service.exeption.ObjectNotFoundException;
import com.lucas.cursomc.domain.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository catRepository;
	
	public Cliente buscar(Integer id) {
		 
		Optional<Cliente> cat = catRepository.findById(id);
		
		return cat.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado" + id + "do Tipo," + Cliente.class.getName()));
	}
}
