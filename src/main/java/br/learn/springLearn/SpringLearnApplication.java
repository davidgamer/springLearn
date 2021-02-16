package br.learn.springLearn;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.learn.springLearn.Entity.Categoria;
import br.learn.springLearn.Entity.Cidade;
import br.learn.springLearn.Entity.Estado;
import br.learn.springLearn.Entity.Produto;
import br.learn.springLearn.Repository.CategoriaRepository;
import br.learn.springLearn.Repository.CidadeRepository;
import br.learn.springLearn.Repository.EstadoRepository;
import br.learn.springLearn.Repository.ProdutoRepository;

@SpringBootApplication
public class SpringLearnApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria (null, "Informática");
		Categoria c2 = new Categoria(null, "Escritorio");
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);	
		
		c1.getProduto().addAll(Arrays.asList(p1, p2, p3));
		c2.getProduto().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1, c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		
		Estado es1 = new Estado(null, "Minas Gerais");
		Estado es2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade (null, "Uberlândia", es1);
		Cidade cidade2 = new Cidade (null, "São Paulo", es2);
		Cidade cidade3 = new Cidade (null, "Campinas", es2);
		
		es1.getCidades().addAll(Arrays.asList(cidade1));
		es2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		categoriaRepository.saveAll(Arrays.asList(c1,c2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(es1, es2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		

	}
}
