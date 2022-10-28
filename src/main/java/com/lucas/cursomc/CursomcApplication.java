package com.lucas.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucas.cursomc.Repositories.CategoriaRepository;
import com.lucas.cursomc.Repositories.CidadeRepository;
import com.lucas.cursomc.Repositories.ClienteRepository;
import com.lucas.cursomc.Repositories.EnderecoRepository;
import com.lucas.cursomc.Repositories.EstadoRepository;
import com.lucas.cursomc.Repositories.ProdutoRepository;
import com.lucas.cursomc.domain.Categoria;
import com.lucas.cursomc.domain.Cidade;
import com.lucas.cursomc.domain.Cliente;
import com.lucas.cursomc.domain.Endereco;
import com.lucas.cursomc.domain.Estado;
import com.lucas.cursomc.domain.Produto;
import com.lucas.cursomc.domain.enums.TipoCliente;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	CategoriaRepository catRepo;
	
	@Autowired
	ProdutoRepository prodRepo;
	
	@Autowired
	EstadoRepository estRepo;
	
	@Autowired
	CidadeRepository cidRepo;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null , "Informática");
		Categoria cat2 = new Categoria(null , "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		catRepo.saveAll(Arrays.asList(cat1, cat2));	
		prodRepo.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia",est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 =  new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estRepo.saveAll(Arrays.asList(est1,est2));
		cidRepo.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli = new Cliente(null,"Maria Silva","maria@gmail.com","87649523",TipoCliente.PESSOAFISICA);
		
		cli.getTelefones().addAll(Arrays.asList("25435523", "432523"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303","Jardim","012341234",cli,c1);
		Endereco e2 =  new Endereco (null, "Avenida Matos", "105", "Sala 103","Centro","0432523",cli,c2);
		
		cli.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
