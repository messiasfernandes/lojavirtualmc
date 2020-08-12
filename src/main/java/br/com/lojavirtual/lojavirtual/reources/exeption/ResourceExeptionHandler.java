package br.com.lojavirtual.lojavirtual.reources.exeption;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.lojavirtual.lojavirtual.service.exeptions.*;

@ControllerAdvice
public class ResourceExeptionHandler {
	@ExceptionHandler(ObejtonaoEncontroadoException.class)
	public ResponseEntity<StandertmsgError >ObjetonaoEncontrado(ObejtonaoEncontroadoException e, HttpServletResponse response){
		StandertmsgError std =new StandertmsgError();
		std.setStatus(HttpStatus.NOT_FOUND.value());
		std.setMsg(e.getMessage());
		std.setTimestamp(  System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(std);
		
	}

}
