package br.com.lojavirtual.lojavirtual.domain;

import java.util.Date;

import javax.persistence.Entity;

import br.com.lojavirtual.lojavirtual.domain.enumerdos.EstadoPagamento;
@Entity
public class PagamentocomBoleto  extends Pagamento{
  
	private static final long serialVersionUID = 1L;
	  private Date datavencimento;
	  private Date datapagmento;
	  
	  
	public PagamentocomBoleto() {
	
	}
	public PagamentocomBoleto(Integer id, EstadoPagamento estadopamento, Pedido pedido, Endereco endrecoentrega, Date datavencimento, Date datapagamento) {
		super(id, estadopamento, pedido);
		this.datavencimento= datavencimento;
		this.datapagmento =datapagamento;
		
	}
	public Date getDatavencimento() {
		return datavencimento;
	}
	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}
	public Date getDatapagmento() {
		return datapagmento;
	}
	public void setDatapagmento(Date datapagmento) {
		this.datapagmento = datapagmento;
	}
}
