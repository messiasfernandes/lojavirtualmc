package br.com.lojavirtual.lojavirtual.service.exeptions;



public class ObejtonaoEncontroadoException extends RuntimeException {

	
	
	

	private static final long serialVersionUID = 5680489242748769353L;

	public ObejtonaoEncontroadoException(String msg) {
		super(msg);
	}
	
	 public ObejtonaoEncontroadoException(String msg, Throwable causa) {
		super(msg,causa);
	}
     
}
