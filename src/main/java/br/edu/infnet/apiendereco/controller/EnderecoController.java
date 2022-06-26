package br.edu.infnet.apiendereco.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiendereco.model.domain.Endereco;
import br.edu.infnet.apiendereco.model.service.EnderecoService;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

	private EnderecoService enderecoService;
	
	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	@GetMapping(value = "/listar")
	public List<Endereco> obterLista() {
		return this.enderecoService.obterLista();
	}

	@GetMapping(value = "/{cep}")
	public Endereco obterLista(@PathVariable String cep) {
		return this.enderecoService.obterPorCep(cep);
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Endereco endereco) {
		this.enderecoService.incluir(endereco);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void remover(@PathVariable Integer id) {
		this.enderecoService.excluir(id);
	}

}
