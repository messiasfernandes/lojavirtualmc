package br.com.lojavirtual.lojavirtual.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.lojavirtual.lojavirtual.domain.enumerdos.TipoCliente;

public class Cliente implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	@Column(length = 14, unique = true)
	private String cpfoucnpj;
	@Enumerated(EnumType.ORDINAL
			)
	private TipoCliente tipocliente;
	private List< Endreco> enderecos = new ArrayList<Endreco>();
	private Set<String>telefone = new HashSet();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfoucnpj() {
		return cpfoucnpj;
	}
	public void setCpfoucnpj(String cpfoucnpj) {
		this.cpfoucnpj = cpfoucnpj;
	}
	public TipoCliente getTipocliente() {
		return tipocliente;
	}
	public void setTipocliente(TipoCliente tipocliente) {
		this.tipocliente = tipocliente;
	}
	public List<Endreco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endreco> enderecos) {
		this.enderecos = enderecos;
	}
	public Set<String> getTelefone() {
		return telefone;
	}
	public void setTelefone(Set<String> telefone) {
		this.telefone = telefone;
	}

}
