package br.com.lojavirtual.lojavirtual.rapositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lojavirtual.lojavirtual.domain.Cidade;
@Repository
public interface CidadeRepsositrory extends JpaRepository<Cidade, Integer> {

}
