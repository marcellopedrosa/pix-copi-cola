package com.github.marcellopedrosa.domain.bacen.entities.pix;

/**
 * Manual de Padrões para Iniciação do Pix 
 * @version 2.6.3
 * 
 * CRC16: ID 63
 * 
 * O Manual do BR Code apresenta a possibilidade de abrigar informações específicas do arranjo na faixa 
 * 26..51 e, como complemento, na faixa 80..99.
 * 
 * @author marcello.pedrosa
 */
public class CRC16 {
	private String id;
	private String tamanho;
	private String urlQrCode;
	private CRC16(Builder builder) {
		this.id = builder.id;
		this.tamanho = builder.tamanho;
		this.urlQrCode = builder.urlQrCode;
	}
	public static class Builder {
		private String id = "63";
		private String tamanho = "04";
		private String urlQrCode;
		public Builder setUrlQrCode(String urlQrCode) {
			this.urlQrCode = urlQrCode.concat(this.id).concat(this.tamanho);
			return this;
		}
		public CRC16 build() {
			return new CRC16(this);
		}
	}
	public String getId() {
		return id;
	}
	public String getTamanho() {
		return tamanho;
	}
	public String getValor() {
		CRC16Algorithm vCRC16CCITT = new CRC16Algorithm();
		vCRC16CCITT.update(this.urlQrCode.getBytes());
		String vCRC16Formmated = String.format("%04x", vCRC16CCITT.getCRC());
		return vCRC16Formmated.toUpperCase();
	}
}
