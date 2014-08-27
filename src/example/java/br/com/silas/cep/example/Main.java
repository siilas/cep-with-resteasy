package br.com.silas.cep.main;

import org.apache.commons.lang3.ArrayUtils;

import br.com.silas.cep.domain.Cep;
import br.com.silas.cep.service.CepService;

public class Main {
	
    public static void main(String[] args) {
    	if (ArrayUtils.isEmpty(args)) {
    		throw new RuntimeException("O número do CEP deve ser ");
    	}
    	    	
    	CepService cepService = new CepService();
    	Cep cep = cepService.buscarCep(args[0]);
    	
    	if (cep.isSucesso()) {
    		System.out.println("Tipo logradouro: " + cep.getTipoLogradouro());
    		System.out.println("Logradouro: " + cep.getLogradouro());
    		System.out.println("Bairro: " + cep.getBairro());
    		System.out.println("Cidade: " + cep.getCidade());
    	} else {
    		System.out.println("CEP não encontrado");
    	}
    }
    
}