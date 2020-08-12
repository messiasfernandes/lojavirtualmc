
package br.com.lojavirtual.lojavirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lojavirtual.lojavirtual.domain.Categoria;
import br.com.lojavirtual.lojavirtual.rapositorys.CategoriaRepository;
import br.com.lojavirtual.lojavirtual.service.exeptions.*;
@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriarepository;

	public Categoria buscaporcodigo(Integer id) {

		Optional<Categoria> categoria = categoriarepository.findById(id);
		if (categoria .isEmpty()) {
			 throw new ObejtonaoEncontroadoException("Objeto não encontrado! Id: " + id
			 + ", Tipo: " + Categoria.class.getName());
			 } 

		return categoria.orElse(null);

	}

	public Categoria salvar(Categoria objeto) {

		return categoriarepository.save(objeto);
	}

	public List<Categoria> buscatodos() {
		return categoriarepository.findAll();

	}
}
