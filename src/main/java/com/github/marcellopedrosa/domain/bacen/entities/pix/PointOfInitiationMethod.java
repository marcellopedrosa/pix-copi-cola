package com.github.marcellopedrosa.domain.bacen.entities.pix;

/**
 * Manual de Padrões para Iniciação do Pix 
 * @version  2.6.3
 * 
 * 1.6.7. Exemplo de QR Code Dinâmico - pág. 21
 * 
 * @author marcello.pedrosa
 */
public class PointOfInitiationMethod {
	private String id;
	private String tamanho;
	private String valor;
	private PointOfInitiationMethod(Builder builder) {
		this.id = builder.id;
		this.tamanho = builder.tamanho;
		this.valor = builder.valor;
	}
	public static class Builder {
		private String id = "01";
		private String tamanho = "02";
		private String valor = "12";
		public PointOfInitiationMethod build() {
			return new PointOfInitiationMethod(this);
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
