package com.github.marcellopedrosa.domain.bacen.entities.pix;

/**
 * Manual de Padrões para Iniciação do Pix 
 * @version 2.6.3
 * 
 * MerchantAccountInformation: ID 26
 * 
 * @author marcello.pedrosa
 */
public class MerchantAccountInformation {
	private String id;
	private MerchantAccountInformationGUI merchantAccountInformationGUI;
	private MerchantAccountInformationURL merchantAccountInformationURL;
	private MerchantAccountInformation(Builder builder) {
		this.id = builder.id;
		this.merchantAccountInformationGUI = builder.merchantAccountInformationGUI;
		this.merchantAccountInformationURL = builder.merchantAccountInformationURL;
	}
	public static class Builder {
		private String id = "26";
		private MerchantAccountInformationGUI merchantAccountInformationGUI;
		private MerchantAccountInformationURL merchantAccountInformationURL;
		public Builder setMerchantAccountInformationGUI(MerchantAccountInformationGUI merchantAccountInformationGUI) {
			this.merchantAccountInformationGUI = merchantAccountInformationGUI;
			return this;
		}
		public Builder setMerchantAccountInformationURL(MerchantAccountInformationURL merchantAccountInformationURL) {
			this.merchantAccountInformationURL = merchantAccountInformationURL;
			return this;
		}
		public MerchantAccountInformation build() {
			return new MerchantAccountInformation(this);
		}
	}
	public String getId() {
		return id;
	}
	
	/**
	 * Tamanho do Merchant Account Infomation (ID 26): Total de caracteres do campo valor (GUI+URL) 
	 * @return
	 */
	public String getTamanho() {
		StringBuilder vTotalCaracteresValorMerchantAccountInformation = new StringBuilder();
		vTotalCaracteresValorMerchantAccountInformation.append(merchantAccountInformationGUI.getId())
												       .append(merchantAccountInformationGUI.getTamanho())
												       .append(merchantAccountInformationGUI.getValor())
												       .append(merchantAccountInformationURL.getId())
												       .append(merchantAccountInformationURL.getTamanho())
												       .append(merchantAccountInformationURL.getValor());
		return String.valueOf(vTotalCaracteresValorMerchantAccountInformation.length());
	}
}
