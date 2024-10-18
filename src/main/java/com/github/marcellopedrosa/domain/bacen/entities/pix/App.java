package com.github.marcellopedrosa.domain.bacen.entities.pix;

/**
 * Run with Java Application
 * 
 * @author marcello.pedrosa
 */
public class App {
	
	public static void main(String[] args) {
		
		MerchantName vMerchantName = new MerchantName.Builder()
													 .setValor("NOME EMPRESA 25 CARACTERS")
													 .build();
		
		MerchantAccountInformationURL vMerchantAccountInformationURL = new MerchantAccountInformationURL.Builder()
																										.setValor("qrcodepix.bb.com.br/pix/v2/cobv/771d89f3-73x7-4e39-829d-ef4fb7615db7")
																										.build();
		
		QRCodeDinamico vQRCodeDinamico = new QRCodeDinamico.Builder()
														   .setMerchantName(vMerchantName)
														   .setMerchantAccountInformationURL(vMerchantAccountInformationURL)
														   .build();
		
		System.out.println(vQRCodeDinamico.getUrlQRCode());
	}
}
