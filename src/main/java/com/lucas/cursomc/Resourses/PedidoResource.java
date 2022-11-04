package com.lucas.cursomc.Resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.cursomc.Service.PedidoService;
import com.lucas.cursomc.domain.Pedido;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService catService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		//Response entity pega e encapusula os metodos http.... se tudo deu certo ele retorna o obj (body = corpo) 
		
		Pedido obj = catService.buscar(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
}
