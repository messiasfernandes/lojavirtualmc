package br.com.lojavirtual.lojavirtual;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.lojavirtual.lojavirtual.domain.Categoria;
import br.com.lojavirtual.lojavirtual.domain.Produto;
import br.com.lojavirtual.lojavirtual.rapositorys.CategoriaRepository;
import br.com.lojavirtual.lojavirtual.rapositorys.ProdutoRepository;



@SpringBootTest
class LojavirtualapiApplicationTests {
	@Autowired
    private CategoriaRepository catdao;
	@Autowired
	ProdutoRepository produtodao;  
	//@Test
	void contextLoads() {
	Categoria cat1 =new Categoria();
	cat1.setNomecategoria("Smarthphone");
	catdao.save(cat1);
	System.out.println("Salvo com sucesso");
	
	}
   @Test
    void salvarprodouto() {
	Optional< Categoria > cat1 = catdao.findById(3) ; 
	   
	 Produto p1 = new Produto();
	 p1.setNomeproduto("GAlaxy s20");
     p1.setPreco(new BigDecimal(3255.85d));
     
     p1.getCategorias().add( cat1.get());
     produtodao.save(p1);  
     System.out.println("Salvo com sucesso");
     
}
}
