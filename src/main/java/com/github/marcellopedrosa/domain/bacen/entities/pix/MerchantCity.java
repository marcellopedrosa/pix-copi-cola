package com.github.marcellopedrosa.domain.bacen.entities.pix;

/**
 * Manual de Padrões para Iniciação do Pix 
 * @version 2.6.3
 * 
 * MerchantCity: ID 60
 * 
 * O Manual do BR Code apresenta a possibilidade de abrigar informações específicas do arranjo na faixa 
 * 26..51 e, como complemento, na faixa 80..99.
 * 
 * @author marcello.pedrosa
 */
public class MerchantCity {
	private String id;
	private String tamanho;
	private String valor;
	private MerchantCity(Builder builder) {
		this.id = builder.id;
		this.tamanho = builder.tamanho;
		this.valor = builder.valor;
	}
	public static class Builder {
		private String id = "60";
		private String tamanho = "TAMANHO DEFINIDO PELO VALOR";
		private String valor = "BRASILIA";
		private void setTamanho() {
			if (this.valor!=null && !this.valor.isBlank()){
				this.tamanho = (this.valor.length()>9 ? String.valueOf(this.valor.length()) : String.valueOf("0"+this.valor.length()));
			} 
		}
		public MerchantCity build() {
			this.setTamanho();
			return new MerchantCity(this);
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
