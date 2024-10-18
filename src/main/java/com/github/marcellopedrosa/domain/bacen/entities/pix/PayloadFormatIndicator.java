package com.github.marcellopedrosa.domain.bacen.entities.pix;

/**
 * Manual de Padrões para Iniciação do Pix 
 * @version 2.6.3
 * 
 * PayloadFormatIndicator: ID 00
 * 
 * O Manual do BR Code apresenta a possibilidade de abrigar informações específicas do arranjo na faixa 
 * 26..51 e, como complemento, na faixa 80..99.
 * 
 * @author marcello.pedrosa
 */
public class PayloadFormatIndicator {
	private String id;
	private String tamanho;
	private String valor;
	private PayloadFormatIndicator(Builder builder) {
		this.id = builder.id;
		this.tamanho = builder.tamanho;
		this.valor = builder.valor;
	}
	public static class Builder {
		private String id = "00";
		private String tamanho = "02";
		private String valor = "01";
		public PayloadFormatIndicator build() {
			return new PayloadFormatIndicator(this);
		}
	}
	public String getId() {
		return id;
	}
	public String getTamanho() {
		return tamanho;
	}
	public String getValor() {
		return valor;
	}
}
