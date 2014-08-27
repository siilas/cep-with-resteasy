package br.com.silas.cep.service;

import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import br.com.silas.cep.domain.Cep;

/**
 * Classe que realiza a busca do CEP e 
 * retorna todas as informações relacionadas
 * ao logradouro
 * 
 * Utiliza o framework RestEasy
 * 
 * @author Silas Maciel Ferreira
 */
public class CepService {

	/**
	 * URL de comunicação com o web service da republica virtual
	 */
	private static final String URI = "http://cep.republicavirtual.com.br/web_cep.php?cep={cep}&formato=xml"; 
	
	/**
	 * Método que busca as informações do logradouro de acordo
	 * com o número do CEP
	 * @see 
	 */
	public Cep buscarCep(String cep) {
		String cepFormatado = formatarCep(cep);
    	ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(URI.replace("{cep}", cepFormatado));
		Response response = target.request().get();
		return response.readEntity(Cep.class);
	}
	
	/**
	 * Formata o cep, tirando espaços e traços
	 * @param cep
	 */
	private String formatarCep(String cep) {
		if (StringUtils.isBlank(cep)) {
			throw new RuntimeException("O número do CEP está vazio!");
		}
		return cep.replace("-", "").trim();
	}
	
}