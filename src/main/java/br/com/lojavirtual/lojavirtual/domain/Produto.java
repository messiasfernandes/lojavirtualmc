package br.com.lojavirtual.lojavirtual.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Column(length = 80, nullable = false)
	private String nomeproduto;

	private BigDecimal preco;

	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias = new ArrayList<Categoria>();
	@OneToMany(mappedBy = "id.produto",fetch=FetchType.EAGER)
	private Set<ItemPedido> items = new HashSet<>();

	public Produto() {

	}

	public Produto(Integer id, String nomeproduto, BigDecimal preco) {
		super();
		this.id = id;
		this.nomeproduto = nomeproduto;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeproduto() {
		return nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto.toUpperCase();
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<ItemPedido> getItems() {
		return items;
	}

	public void setItems(Set<ItemPedido> items) {
		this.items = items;
	}
	public List<Pedido> getPedidos(){
		List<Pedido> lista =new ArrayList<Pedido>();
		for(ItemPedido i : items) {
			lista.add(i.gePedido());
		}
		return lista;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
