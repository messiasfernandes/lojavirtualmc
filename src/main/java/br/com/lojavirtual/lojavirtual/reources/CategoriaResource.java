package br.com.lojavirtual.lojavirtual.reources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lojavirtual.lojavirtual.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	@GetMapping
	public ResponseEntity<?>listar(){
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Eletônicos");
		List<Categoria>colecaocategoria = new ArrayList<>();
		colecaocategoria.add(cat1);
		colecaocategoria.add(cat2);
		return ResponseEntity.status(HttpStatus.OK).body( colecaocategoria);
	}

}
