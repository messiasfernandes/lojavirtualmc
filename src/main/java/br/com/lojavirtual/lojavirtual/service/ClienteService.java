package br.com.lojavirtual.lojavirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lojavirtual.lojavirtual.domain.Cliente;

import br.com.lojavirtual.lojavirtual.rapositorys.ClienteRepository;
import br.com.lojavirtual.lojavirtual.service.exeptions.ObejtonaoEncontroadoException;
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienterepository;

	public Cliente buscaporcodigo(Integer id) {

		Optional<Cliente> cliente = clienterepository.findById(id);
		if (cliente .isEmpty()) {
			 throw new ObejtonaoEncontroadoException("Objeto não encontrado! Id: " + id
			 + ", Tipo: " + Cliente.class.getName());
			 } 

		return cliente.orElse(null);

	}

	public Cliente salvar(Cliente objeto) {

		return clienterepository.save(objeto);
	}

	public List<Cliente> buscatodos() {
		return clienterepository.findAll();

	}
	
}
