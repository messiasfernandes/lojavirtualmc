package br.com.lojavirtual.lojavirtual.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Entity
public class ItemPedido  implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ItemPedidoPk id = new ItemPedidoPk();
	private BigDecimal desconto;
	private Integer qtde;
	private BigDecimal preco;

	public ItemPedido() {

	}

	public ItemPedido(Pedido pedido, Produto produto, BigDecimal desconto, Integer qtde, BigDecimal preco) {
		super();
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.desconto = desconto;
		this.qtde = qtde;
		this.preco = preco;
	}

	public Pedido gePedido() {
		return id.getPedido();
	}

	public Produto geProduto() {
		return id.getProduto();
	}

	public ItemPedidoPk getId() {
		return id;
	}

	public void setId(ItemPedidoPk id) {
		this.id = id;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
