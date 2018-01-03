package br.com.desafio;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.desafio.modelos.Gerenciador;
import br.com.desafio.servicos.GerenciadorService;

@Controller
public class GerenciadorController {

	@Autowired
	public GerenciadorService service;

	@RequestMapping("/")
	private String index() {
		return "index";
	}

	// Lista senhas salvas
	@RequestMapping("homeinicio")
	public String usuarioLogado(Model model) {

		Iterable<Gerenciador> lista = service.obterLista();
		model.addAttribute("lista", lista);

		return "homeinicio";
	}

	@RequestMapping("homeinicio/")
	public String usuario(Model model) {

		Iterable<Gerenciador> lista = service.obterLista();
		model.addAttribute("lista", lista);

		return "redirect:/homeinicio";
	}

	// Adiciona novo serviço e senha
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("servico") String servico, @RequestParam("email") String email,
			@RequestParam("senha") String senha, @Valid Gerenciador gerenciador, BindingResult result,
			RedirectAttributes attribute, Model model) {

		// Mensagem de erro
		if (result.hasErrors()) {
			attribute.addFlashAttribute("mensagem",
					"Falha ao tentar salvar nova senha, verifique se os dados informados estão corretos.");
			Iterable<Gerenciador> viewAtualizada = service.obterLista();
			model.addAttribute("lista", viewAtualizada);
			return "redirect:/homeinicio";
		}

		// Passa parametro e retorna mensagem de sucesso
		gerenciador = new Gerenciador(servico, email, senha);
		service.salvar(gerenciador);
		attribute.addFlashAttribute("mensagem", "Nova senha adicionada com sucesso!");

		// Atualiza a view
		Iterable<Gerenciador> viewAtualizada = service.obterLista();
		model.addAttribute("lista", viewAtualizada);

		return "redirect:/homeinicio";
	}

	// Excluir dados
	@RequestMapping(value = "deletar/{id}")
	public String deletar(@PathVariable("id") Integer id, RedirectAttributes attribute, Model model) {

		Gerenciador gerenciador = service.buscaId(id);
		service.excluir(gerenciador);
		attribute.addFlashAttribute("mensagem", "Senha excluida com sucesso!");

		Iterable<Gerenciador> viewAtualizada = service.obterLista();
		model.addAttribute("lista", viewAtualizada);

		return "redirect:/homeinicio";
	}

	// Editar dados
	@RequestMapping(value = "editar", method=RequestMethod.PUT)
	public String editar(Gerenciador valores, @RequestParam("id") Integer id, BindingResult result,
			RedirectAttributes attribute, Model model) {
		/*
		Gerenciador novo = service.buscaId(id);

		if (result.hasErrors()) {
			attribute.addFlashAttribute("mensagem", "Falha ao tentar editar os dados.");
		}

		novo.setServico(valores.getServico());
		novo.setEmail(valores.getEmail());
		novo.setSenha(valores.getSenha());
		service.update(novo);
		attribute.addFlashAttribute("mensagem", "Dados editados com sucesso!");

		Iterable<Gerenciador> viewAtualizada = service.obterLista();
		model.addAttribute("lista", viewAtualizada);
		attribute.addFlashAttribute("mensagem", "Funcionalidade indisponível no momento.");
		*/
		attribute.addFlashAttribute("mensagem", "Operação indisponível no momento.");
		
		return "Redirect:homeinicio";

	}
}
