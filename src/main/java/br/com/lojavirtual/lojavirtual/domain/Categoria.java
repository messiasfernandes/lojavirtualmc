package br.com.lojavirtual.lojavirtual.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Categoria implements Serializable {

	
	private static final long serialVersionUID = 1L;
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
   
    @Column(length = 60, unique = true, nullable = false)
	private String nomecategoria;
///	@JsonInclude(content =  Include.NON_NULL)
    @JsonManagedReference
    @ManyToMany(mappedBy = "categorias")
	private List<Produto>produtos = new ArrayList<Produto>();
	public Categoria() {
		
	}
	public Categoria(Integer id, String nomecategoria) {
		super();
		this.id = id;
		this.nomecategoria = nomecategoria;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomecategoria() {
		return nomecategoria;
	}
	public void setNomecategoria(String nomecategoria) {
		this.nomecategoria = nomecategoria.toUpperCase();
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nomecategoria=" + nomecategoria + "]";
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
   
}
