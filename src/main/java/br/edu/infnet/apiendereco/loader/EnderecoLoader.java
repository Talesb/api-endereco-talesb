package br.edu.infnet.apiendereco.loader;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apiendereco.model.domain.Endereco;
import br.edu.infnet.apiendereco.model.service.EnderecoService;

@Component
public class EnderecoLoader implements ApplicationRunner {

	private EnderecoService enderecoService;

	public EnderecoLoader(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		String cep = "12345678";

		Endereco endereco = new Endereco();

		try {
			endereco.setBairro("Centro");
			endereco.setCep(cep);
			endereco.setComplemento("Segundo andar");
			endereco.setLocalidade("Rio de Janeio");
			endereco.setLogradouro("São Jose, 90");
			endereco.setUf("RJ");

			this.enderecoService.incluir(endereco);

			System.out.println("Gravação de endereço realizada com sucesso!");

		} catch (Exception e) {
			System.out.println("Gravação de endereço não realizada.");

			Endereco enderecoObtido = this.enderecoService.obterPorCep(cep);
			System.out.println("Endereco Obtido -> " + enderecoObtido.toString());

			try {
				endereco.setCep("87654321");
				this.enderecoService.incluir(endereco);
			} catch (Exception ex) {
				System.out.println("Gravação de endereço não realizada.");
			}

			List<Endereco> enderecos = this.enderecoService.obterLista();

			enderecos.forEach(enderecoP -> {
				System.out.println("Endereco encontrado -> " + enderecoP.toString());
			});

			System.out.println("Endereco a ser excluido -> " + enderecoObtido.getCep());
			this.enderecoService.excluir(enderecoObtido.getId());

		}

	}

}
