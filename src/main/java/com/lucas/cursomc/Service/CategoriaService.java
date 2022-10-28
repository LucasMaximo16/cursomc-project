package com.lucas.cursomc.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.cursomc.Repositories.CategoriaRepository;
import com.lucas.cursomc.Service.exeption.ObjectNotFoundException;
import com.lucas.cursomc.domain.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository catRepository;
	
	public Categoria buscar(Integer id) {
		 
		Optional<Categoria> cat = catRepository.findById(id);
		
		return cat.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado" + id + "do Tipo," + Categoria.class.getName()));
	}
}
