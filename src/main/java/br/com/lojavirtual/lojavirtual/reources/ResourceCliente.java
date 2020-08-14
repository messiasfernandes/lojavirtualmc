package br.com.lojavirtual.lojavirtual.reources;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import br.com.lojavirtual.lojavirtual.domain.Cliente;

import br.com.lojavirtual.lojavirtual.service.ClienteService;

@RestController
@RequestMapping(value  = "/clientes")
public class ResourceCliente {
   @Autowired
	private ClienteService clienteservice;

	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {

		return ResponseEntity.status(HttpStatus.OK).body(clienteservice.buscatodos());
	}

	@GetMapping("{id}")
	public ResponseEntity<Cliente> finprimarykey(@PathVariable Integer id) {
		Cliente cliente = clienteservice.buscaporcodigo(id);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}
   @PostMapping
	public ResponseEntity<?> salvar(@RequestBody Cliente objeto, HttpServletResponse response) {

		Cliente clientesalvo = clienteservice.salvar(objeto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{codigo}")
				.buildAndExpand(clientesalvo.getId()).toUri();
		response.setHeader("LoCation", uri.toASCIIString());

		return ResponseEntity.created(uri).body(clientesalvo);
	}

	
}
