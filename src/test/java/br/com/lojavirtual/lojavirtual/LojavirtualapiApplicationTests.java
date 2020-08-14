package br.com.lojavirtual.lojavirtual;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.lojavirtual.lojavirtual.domain.Categoria;
import br.com.lojavirtual.lojavirtual.domain.Cidade;
import br.com.lojavirtual.lojavirtual.domain.Cliente;
import br.com.lojavirtual.lojavirtual.domain.Endereco;

import br.com.lojavirtual.lojavirtual.domain.Estado;
import br.com.lojavirtual.lojavirtual.domain.ItemPedido;
import br.com.lojavirtual.lojavirtual.domain.Pagamento;
import br.com.lojavirtual.lojavirtual.domain.PagamentocomBoleto;
import br.com.lojavirtual.lojavirtual.domain.PagmentocomCartao;
import br.com.lojavirtual.lojavirtual.domain.Pedido;
import br.com.lojavirtual.lojavirtual.domain.Produto;
import br.com.lojavirtual.lojavirtual.domain.enumerdos.EstadoPagamento;
import br.com.lojavirtual.lojavirtual.domain.enumerdos.TipoCliente;
import br.com.lojavirtual.lojavirtual.rapositorys.CategoriaRepository;
import br.com.lojavirtual.lojavirtual.rapositorys.CidadeRepsositrory;
import br.com.lojavirtual.lojavirtual.rapositorys.ClienteRepository;
import br.com.lojavirtual.lojavirtual.rapositorys.EndrecoRepository;
import br.com.lojavirtual.lojavirtual.rapositorys.EstadoRepository;
import br.com.lojavirtual.lojavirtual.rapositorys.ItempedidoRepository;
import br.com.lojavirtual.lojavirtual.rapositorys.PagamentoRepository;
import br.com.lojavirtual.lojavirtual.rapositorys.PedidoRepositroy;
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
	@Autowired
	ClienteRepository clientedao;
	@Autowired
	EndrecoRepository enddao;
	@Autowired
    PagamentoRepository pagamentodao;
	@Autowired
    PedidoRepositroy pedidodao;
	@Autowired
	ItempedidoRepository itemdao;
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

	
	public void salvarEstdo() {
		Estado estado1 = new Estado(null, "PARANÁ");
	//	Estado estado2 = new Estado(null, "SÃO PAULO ");
		Cidade cidade1 = new Cidade(null, "FOZ DO IGUAÇU", estado1);
		
		//Cidade cidade2 = new Cidade(null, "CAMPINAS", estado2);
	//	Cidade cidade3 = new Cidade(null, "SAO PAULO", estado2);
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estadodao.save(estado1);
		cidadedao.save(cidade1);
	//	estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
	//	estadodao.saveAll(Arrays.asList(estado1, estado2));
	//	cidadedao.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		System.out.println("Salvo com sucesso");

	}
	
	public void salvarcliente() {
     Optional<Cidade> cidade = cidadedao.findById(1);
     Optional<Cidade> cidade2 = cidadedao.findById(4);
		Cliente cliente1 =new Cliente(null, "Messias Silviera", "messias@gmail.com", "1247787", TipoCliente.PESSOAFISICA);
		cliente1.getTelefone().addAll(Arrays.asList("35221000","989787878"));
		Endereco end1 = new Endereco(null," RUA MAJOR VALERIANO", 60, "CASA", "CENTRO", "35250", cidade.get(), cliente1);
		Endereco end2 = new Endereco(null," R PILAR", 615, "CASA", "JARDIM DAS PALMEIRAS", "85869748", cidade2.get(), cliente1);
		//cliente1.getEnderecos().addAll(Arrays.asList(end1,end2));
	clientedao.save(cliente1);
	enddao.saveAll(Arrays.asList(end1,end2));
	}

  public void addproduto () {

  }
	
	@Test
	public void salvarPedido() {
	
		 
	 Optional<Endereco>	enderecoEntrega =enddao.findById(1);
		Optional<Cliente> cliente = clientedao.findById(1);
		LocalDate data = LocalDate.now();
		Date datavencimento=new Date();
		Pedido pedido =new Pedido(null,data , cliente.get(), enderecoEntrega.get());
		///Pedido p2= new Pedido(id, instante, cliente, pagamento, enderecoEntrega)
		Pagamento pag1 = new PagamentocomBoleto(null, EstadoPagamento.PENDENTE, pedido, enderecoEntrega.get(), datavencimento,null);
		pedido.setPagamento(pag1);
		Optional<Produto> p1= produtodao.findById(1);
		BigDecimal total= p1.get().getPreco().multiply(new BigDecimal(2));
		Integer qtde =2;
		BigDecimal desconto = new BigDecimal("0.00");
		  ItemPedido item =new ItemPedido(pedido, p1.get(),desconto , qtde, total);
       
		  System.out.print(p1.get().getNomeproduto());
       pedido.getItems().add(item);
       System.out.print("TEstee"+item.geProduto().getId());
      p1.get().getItems().add(item);
      pedidodao.save(pedido);
      itemdao.save(item);	

		
		
		System.out.println("Salvo com sucesso");
		
	//	Pagamento pag1 = new PagamentocomBoleto(null, EstadoPagamento.PENDENTE, pedido, enderecoEntrega.get(),datavencimento, null);
	//	Pagamento pag2 = new PagmentocomCartao(id, estadopamento, pedido, endrecoentrega, numeroParcelas)
	}
}
