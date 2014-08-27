package br.com.silas.cep.service;

import junit.framework.Assert;

import org.junit.Test;

import br.com.silas.cep.domain.Cep;

/**
 * Testes para a comunicação com
 * o web service da republica virtual
 * 
 * @author Silas Maciel Ferreira
 */
public class CepServiceTest {

	private CepService cepService = new CepService();
	
	@Test
	public void deveBuscarCepComSucesso() {
		String cepAvPaulista = "01311-300";
		Cep cep = cepService.buscarCep(cepAvPaulista);
		Assert.assertEquals("Paulista", cep.getLogradouro());
	}
	
	@Test(expected = RuntimeException.class)
	public void deveGerarException() {
		String cepInvalido = "";
		cepService.buscarCep(cepInvalido);
	}
}