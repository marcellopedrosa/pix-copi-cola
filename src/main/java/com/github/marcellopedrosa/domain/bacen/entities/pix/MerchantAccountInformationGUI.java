package com.github.marcellopedrosa.domain.bacen.entities.pix;

/**
 * Manual de Padrões para Iniciação do Pix 
 * @version 2.6.3
 * 
 * MerchantAccountInformation: ID 26 > MerchantAccountInformationGUI: ID 00
 * @see "26" "indica arranjo específico; "00" (GUI) obrigatório (pág. 2)
 * 
 * @author marcello.pedrosa
 */
public class MerchantAccountInformationGUI {
	private String id;
	private String tamanho;
	private String valor;
	private MerchantAccountInformationGUI(Builder builder) {
		this.id = builder.id;
		this.tamanho = builder.tamanho;
		this.valor = builder.valor;
	}
	public static class Builder {
		private String id = "00";
		private String tamanho = "14";
		private String valor = "br.gov.bcb.pix";
		public MerchantAccountInformationGUI build() {
			return new MerchantAccountInformationGUI(this);
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
