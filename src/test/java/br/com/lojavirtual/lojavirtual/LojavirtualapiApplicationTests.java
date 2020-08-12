package br.com.lojavirtual.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.lojavirtual.lojavirtual.domain.Categoria;
import br.com.lojavirtual.lojavirtual.rapositorys.CategoriaRepository;



@SpringBootTest
class LojavirtualapiApplicationTests {
	@Autowired
    private CategoriaRepository catdao;
	@Test
	void contextLoads() {
	Categoria cat1 =new Categoria();
	cat1.setNomecategoria("Perfumes");
	catdao.save(cat1);
	System.out.println("Salvo com sucesso");
	
	}

}
