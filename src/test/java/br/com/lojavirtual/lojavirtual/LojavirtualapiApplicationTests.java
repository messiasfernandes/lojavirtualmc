package br.com.lojavirtual.lojavirtual;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.lojavirtual.lojavirtual.domain.Categoria;
import br.com.lojavirtual.lojavirtual.domain.Cidade;
import br.com.lojavirtual.lojavirtual.domain.Estado;
import br.com.lojavirtual.lojavirtual.domain.Produto;
import br.com.lojavirtual.lojavirtual.rapositorys.CategoriaRepository;
import br.com.lojavirtual.lojavirtual.rapositorys.CidadeRepsositrory;
import br.com.lojavirtual.lojavirtual.rapositorys.EstadoRepository;
import br.com.lojavirtual.lojavirtual.rapositorys.ProdutoRepository;

@SpringBootTest
class LojavirtualapiApplicationTests {
	@Autowired
	private CategoriaRepository catdao;
	@Autowired
	ProdutoRepository produtodao;
	@Autowired
	EstadoRepository estadodao;
	@Autowired
	CidadeRepsositrory cidadedao;

	// @Test
	void contextLoads() {
		Categoria cat1 = new Categoria();
		cat1.setNomecategoria("Smarthphone");
		catdao.save(cat1);
		System.out.println("Salvo com sucesso");

	}

	// @Test
	void salvarprodouto() {
		Optional<Categoria> cat1 = catdao.findById(3);

		Produto p1 = new Produto();
		p1.setNomeproduto("GAlaxy s20");
		p1.setPreco(new BigDecimal(3255.85d));

		p1.getCategorias().add(cat1.get());
		produtodao.save(p1);
		System.out.println("Salvo com sucesso");

	}

	@Test
	public void salvarEstdo() {
		Estado estado1 = new Estado(null, "MINAS GERAIS");
		Estado estado2 = new Estado(null, "SÃO PAULO ");
		Cidade cidade1 = new Cidade(null, "ARCOS", estado1);
		Cidade cidade2 = new Cidade(null, "CAMPINAS", estado2);
		Cidade cidade3 = new Cidade(null, "SAO PAULO", estado2);
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		estadodao.saveAll(Arrays.asList(estado1, estado2));
		cidadedao.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		System.out.println("Salvo com sucesso");

	}
}
