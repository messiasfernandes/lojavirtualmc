package br.com.lojavirtual.lojavirtual.rapositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lojavirtual.lojavirtual.domain.Cidade;

public interface CidadeRepsositrory extends JpaRepository<Cidade, Integer> {

}
