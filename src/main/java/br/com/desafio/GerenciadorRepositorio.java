package br.com.desafio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.desafio.modelos.*;

@Repository
public interface GerenciadorRepositorio extends CrudRepository<Gerenciador, Integer> {
	Gerenciador findById(Integer id);
}
