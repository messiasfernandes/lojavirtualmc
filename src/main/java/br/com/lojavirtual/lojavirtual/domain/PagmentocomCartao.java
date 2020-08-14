package br.com.lojavirtual.lojavirtual.domain;

import javax.persistence.Entity;

import br.com.lojavirtual.lojavirtual.domain.enumerdos.EstadoPagamento;
@Entity
public class PagmentocomCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	private Integer numeroParcelas;

	public PagmentocomCartao() {
		
	}

	public PagmentocomCartao(Integer id, EstadoPagamento estadopamento, Pedido pedido, Endereco endrecoentrega,
			Integer numeroParcelas) {
		super(id, estadopamento, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
}
