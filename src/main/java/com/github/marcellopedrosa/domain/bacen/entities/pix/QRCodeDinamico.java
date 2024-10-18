package com.github.marcellopedrosa.domain.bacen.entities.pix;

/**
 * Manual de Padrões para Iniciação do Pix
 * @version 2.6.3
 * 
 * @see 1.6. Iniciação do Pix via QR Code Dinâmico pág. 7
 */
public class QRCodeDinamico {
	
	private PayloadFormatIndicator payloadFormatIndicator;
	private PointOfInitiationMethod pointOfInitiationMethod;
	private MerchantAccountInformation merchantAccountInformation;
	private MerchantAccountInformationGUI merchantAccountInformationGUI;
	private MerchantAccountInformationURL merchantAccountInformationURL;
	private MerchantCategoryCode merchantCategoryCode;
	private TransactionCurrency transactionCurrency;
	private CountryCode countryCode;
	private MerchantName merchantName;
	private MerchantCity merchantCity;
	private AdditionalDataField additionalDataField;
	private AdditionalDataFieldReferenceLabel additionalDataFieldReferenceLabel;
		
	private QRCodeDinamico(Builder builder) {
		this.payloadFormatIndicator = builder.payloadFormatIndicator;
		this.pointOfInitiationMethod = builder.pointOfInitiationMethod;
		this.merchantAccountInformation = builder.merchantAccountInformation;
		this.merchantAccountInformationGUI = builder.merchantAccountInformationGUI;
		this.merchantAccountInformationURL = builder.merchantAccountInformationURL;
		this.merchantCategoryCode = builder.merchantCategoryCode;
		this.transactionCurrency = builder.transactionCurrency;
		this.countryCode = builder.countryCode;
		this.merchantName = builder.merchantName;
		this.merchantCity = builder.merchantCity;
		this.additionalDataField = builder.additionalDataField;
		this.additionalDataFieldReferenceLabel = builder.additionalDataFieldReferenceLabel;
	}

	public static class Builder {
		private PayloadFormatIndicator payloadFormatIndicator = new PayloadFormatIndicator.Builder().build();
		private PointOfInitiationMethod pointOfInitiationMethod = new PointOfInitiationMethod.Builder().build();
		private MerchantAccountInformation merchantAccountInformation;
		private MerchantAccountInformationGUI merchantAccountInformationGUI = new MerchantAccountInformationGUI.Builder().build();
		private MerchantAccountInformationURL merchantAccountInformationURL;
		private MerchantCategoryCode merchantCategoryCode = new MerchantCategoryCode.Builder().build();
		private TransactionCurrency transactionCurrency = new TransactionCurrency.Builder().build();
		private CountryCode countryCode = new CountryCode.Builder().build();
		private AdditionalDataField additionalDataField = new AdditionalDataField.Builder().build();
		private AdditionalDataFieldReferenceLabel additionalDataFieldReferenceLabel = new AdditionalDataFieldReferenceLabel.Builder().build();
		private MerchantCity merchantCity = new MerchantCity.Builder().build();
		private MerchantName merchantName;
		public Builder setMerchantAccountInformationURL(MerchantAccountInformationURL merchantAccountInformationURL) {
			this.merchantAccountInformationURL = merchantAccountInformationURL;
			return this;
		}
		public Builder setMerchantName(MerchantName merchantName) {
			this.merchantName = merchantName;
			return this;
		}
		public Builder configMerchantAccountInformation() {
			this.merchantAccountInformation = new MerchantAccountInformation.Builder()
																			.setMerchantAccountInformationGUI(this.merchantAccountInformationGUI)
																			.setMerchantAccountInformationURL(this.merchantAccountInformationURL)
																			.build();
			return this;
		}
		public QRCodeDinamico build() {
			this.configMerchantAccountInformation();
			return new QRCodeDinamico(this);
		}
	}
	
	public String getUrlQRCode() {
		
		StringBuilder vQrCodeLinha = new StringBuilder();
		
		   vQrCodeLinha.append(this.payloadFormatIndicator.getId())
					   .append(this.payloadFormatIndicator.getTamanho())
					   .append(this.payloadFormatIndicator.getValor())
				
					   .append(this.pointOfInitiationMethod.getId())
					   .append(this.pointOfInitiationMethod.getTamanho())
					   .append(this.pointOfInitiationMethod.getValor())
					   
					   .append(this.merchantAccountInformation.getId())
				       .append(this.merchantAccountInformation.getTamanho())
					   .append(this.merchantAccountInformationGUI.getId())
				       .append(this.merchantAccountInformationGUI.getTamanho())
					   .append(this.merchantAccountInformationGUI.getValor())
					   .append(this.merchantAccountInformationURL.getId())
				       .append(this.merchantAccountInformationURL.getTamanho())
				       .append(this.merchantAccountInformationURL.getValor())
				       
				       .append(this.merchantCategoryCode.getId())
					   .append(this.merchantCategoryCode.getTamanho())
					   .append(this.merchantCategoryCode.getValor())
				
					   .append(this.transactionCurrency.getId())
					   .append(this.transactionCurrency.getTamanho())
					   .append(this.transactionCurrency.getValor())
				
				       .append(this.countryCode.getId())
					   .append(this.countryCode.getTamanho())
					   .append(this.countryCode.getValor())
				
				       .append(this.merchantName.getId())
					   .append(this.merchantName.getTamanho())
					   .append(this.merchantName.getValor())
				
				       .append(this.merchantCity.getId())
					   .append(this.merchantCity.getTamanho())
					   .append(this.merchantCity.getValor())
		
				       .append(this.additionalDataField.getId())
					   .append(this.additionalDataField.getTamanho())
					   .append(this.additionalDataFieldReferenceLabel.getId())
					   .append(this.additionalDataFieldReferenceLabel.getTamanho())
					   .append(this.additionalDataFieldReferenceLabel.getValor());
		
		CRC16 vCRC16 = new CRC16.Builder()
							    .setUrlQrCode(vQrCodeLinha.toString())
							    .build();
		
		vQrCodeLinha.append(vCRC16.getId());
		vQrCodeLinha.append(vCRC16.getTamanho());
		vQrCodeLinha.append(vCRC16.getValor());
		
		return vQrCodeLinha.toString();
	}
}
