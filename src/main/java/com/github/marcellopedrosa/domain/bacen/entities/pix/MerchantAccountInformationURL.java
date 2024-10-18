package com.github.marcellopedrosa.domain.bacen.entities.pix;

/**
 * Manual de Padrões para Iniciação do Pix 
 * @version 2.6.3
 * 
 * MerchantAccountInformation: ID 26 > MerchantAccountInformationURL: ID 25
 * 
 * 1.6.3. A URL hospedada no PSP do recebedor: Location
 * 
 * @author marcello.pedrosa
 */
public class MerchantAccountInformationURL {
	private String id;
	private String tamanho;
	private String valor;
	private MerchantAccountInformationURL(Builder builder) {
		this.id = builder.id;
		this.tamanho = builder.tamanho;
		this.valor = builder.valor;
	}
	public static class Builder {
		private String id = "25";
		private String tamanho = "OBRIGATORIO_MerchantAccountInformationURL.tamanho";
		private String valor = "OBRIGATORIO_MerchantAccountInformationURL.valor";
		public Builder setValor(String valor) {
			this.valor = valor;
			return this;
		}
		private void setTamanho() {
			if (this.valor!=null && !this.valor.isBlank()){
				this.tamanho = (this.valor.length()>9 ? String.valueOf(this.valor.length()) : String.valueOf("0"+this.valor.length()));
			} 
		}
		public MerchantAccountInformationURL build() {
			this.setTamanho();
			return new MerchantAccountInformationURL(this);
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
