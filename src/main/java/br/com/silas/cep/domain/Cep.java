package br.com.silas.cep.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Objeto retornado na consulta do CEP através
 * do web service da republica virtual
 * 
 * @author Silas Maciel Ferreira
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "webservicecep")
public class Cep implements Serializable {

	private static final long serialVersionUID = 6742335908895864187L;

	/**
	 * Resultado da consulta, o valor 1 representa sucesso na consulta
	 * e 0, representa falha
	 */
	@XmlElement(name = "resultado")
	private int resultado;
	
	/**
	 * Texto com uma breve descrição do resultado
	 */
	@XmlElement(name = "resultado_txt")
	private String resultadoTxt;
	
	/**
	 * Nome da cidade em que está localizado o logradouro
	 */
	@XmlElement(name = "cidade")
	private String cidade;
	
	/**
	 * Nome do bairro em que está localizado o logradouro
	 */
	@XmlElement(name = "bairro")
	private String bairro;
	
	/**
	 * Indica se o logradouro é avenida, rua, etc.
	 */
	@XmlElement(name = "tipo_logradouro")
	private String tipoLogradouro;
	
	/**
	 * Nome do logradouro
	 */
	@XmlElement(name = "logradouro")
	private String logradouro;

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	public String getResultadoTxt() {
		return resultadoTxt;
	}

	public void setResultadoTxt(String resultadoTxt) {
		this.resultadoTxt = resultadoTxt;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	/**
	 * Retorna o resultado da requisição,
	 * true para sucesso e false para falha
	 */
	public boolean isSucesso() {
		return resultado == 1;
	}
	
}