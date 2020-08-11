package br.com.lojavirtual.lojavirtual.domain;

import java.io.Serializable;

public class Categoria implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomecategoria;
	
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
		this.nomecategoria = nomecategoria;
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
   
}
