package br.edu.infnet.apiendereco.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.apiendereco.model.domain.Endereco;
import br.edu.infnet.apiendereco.model.repository.EnderecoRepository;

@Service
public class EnderecoService {

	private EnderecoRepository enderecoRepository;

	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	public List<Endereco> obterLista() {
		return (List<Endereco>) enderecoRepository.findAll();

	}

	public void incluir(Endereco endereco) {
		  enderecoRepository.save(endereco);

	}

	public  Endereco obterPorCep(String cep) {
		return enderecoRepository.findByCep(cep);

	}

	public void excluir(Integer enderecoId) {
		enderecoRepository.deleteById(enderecoId);

	}

}
