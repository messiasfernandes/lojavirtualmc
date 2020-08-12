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

import br.com.lojavirtual.lojavirtual.domain.Categoria;
import br.com.lojavirtual.lojavirtual.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	@Autowired
	private CategoriaService categoriasevice;

	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {

		return ResponseEntity.status(HttpStatus.OK).body(categoriasevice.buscatodos());
	}

	@GetMapping("{id}")
	public ResponseEntity<Categoria> finprimarykey(@PathVariable Integer id) {
		Categoria categoria = categoriasevice.buscaporcodigo(id);
		return ResponseEntity.status(HttpStatus.OK).body(categoria);
	}
   @PostMapping
	public ResponseEntity<?> salvar(@RequestBody Categoria objeto, HttpServletResponse response) {

		Categoria categoriasalva = categoriasevice.salvar(objeto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{codigo}")
				.buildAndExpand(categoriasalva.getId()).toUri();
		response.setHeader("LoCation", uri.toASCIIString());

		return ResponseEntity.created(uri).body(categoriasalva);
	}

}
