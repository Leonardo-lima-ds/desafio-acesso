package br.com.desafio.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.desafio.GerenciadorRepositorio;
import br.com.desafio.modelos.Gerenciador;

@Service
public class GerenciadorService {

	@Autowired
	public GerenciadorRepositorio repositorio;

	public Iterable<Gerenciador> obterLista() {

		// Passa senhas para view
		Iterable<Gerenciador> lista = repositorio.findAll();
		return lista;
	}

	public Gerenciador buscaId(Integer id) {
		
		Gerenciador lista = repositorio.findById(id);
		return lista;
	}

	public synchronized void salvar(Gerenciador valores) {
		repositorio.save(valores);
	}

	public void excluir(Gerenciador valores) {
		repositorio.delete(valores);
	}
	
	public void update(Gerenciador valores) {
		 salvar(valores);
	}
}
