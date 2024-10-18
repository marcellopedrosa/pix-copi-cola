package com.github.marcellopedrosa.domain.bacen.entities.pix;

/**
 * Manual de Padrões para Iniciação do Pix 
 * @version 2.6.3
 * 
 * AdditionalDataField: ID 62
 * 
 * O Manual do BR Code apresenta a possibilidade de abrigar informações específicas do arranjo na faixa 
 * 26..51 e, como complemento, na faixa 80..99.
 * 
 * @author marcello.pedrosa
 */
public class AdditionalDataField {
	private String id;
	private String tamanho;
	private AdditionalDataField(Builder builder) {
		this.id = builder.id;
		this.tamanho = builder.tamanho;
	}
	public static class Builder {
		private String id = "62";
		private String tamanho = "07";
		public AdditionalDataField build() {
			return new AdditionalDataField(this);
		}
	}
	public String getId() {
		return id;
	}
	public String getTamanho() {
		return tamanho;
	}
}
