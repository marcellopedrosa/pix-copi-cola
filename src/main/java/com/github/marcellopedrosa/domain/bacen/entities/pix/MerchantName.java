package com.github.marcellopedrosa.domain.bacen.entities.pix;

/**
 * Manual de Padrões para Iniciação do Pix 
 * @version 2.6.3
 * 
 * MerchantName: ID 59
 * 
 * O Manual do BR Code apresenta a possibilidade de abrigar informações específicas do arranjo na faixa 
 * 26..51 e, como complemento, na faixa 80..99.
 * 
 * @author marcello.pedrosa
 */
public class MerchantName {
	private String id;
	private String tamanho;
	private String valor;
	private MerchantName(Builder builder) {
		this.id = builder.id;
		this.tamanho = builder.tamanho;
		this.valor = builder.valor;
	}
	public static class Builder {
		private String id = "59";
		private String tamanho = "OBRIGATORIO_MerchantName.tamanho";
		private String valor = "OBRIGATORIO_MerchantName.valor";
		private void setTamanho() {
			if (this.valor!=null && !this.valor.isBlank()) {
				this.tamanho = (this.valor.length()>9 ? String.valueOf(this.valor.length()) : String.valueOf("0"+this.valor.length()));
			} 
		}
		public Builder setValor(String valor) {
			this.valor = valor;
			return this;
		}
		public MerchantName build() {
			this.setTamanho();
			return new MerchantName(this);
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
