package com.github.marcellopedrosa.domain.bacen.entities.pix;

public class CRC16Algorithm {

	 // Polinômio padrão CRC-16-CCITT
    private static final int POLY = 0x1021;
    private int crc;

    public CRC16Algorithm() {
        crc = 0xFFFF;  // Valor inicial padrão
    }

    public void update(byte[] data) {
        for (byte b : data) {
            crc ^= (b << 8);
            for (int i = 0; i < 8; i++) {
                if ((crc & 0x8000) != 0) {
                    crc = (crc << 1) ^ POLY;
                } else {
                    crc <<= 1;
                }
            }
            crc &= 0xFFFF;  // Garante que o CRC seja de 16 bits
        }
    }

    public int getCRC() {
        return crc & 0xFFFF;
    }

    public static void main(String[] args) {
    	CRC16Algorithm crc16 = new CRC16Algorithm();
        String input = "00020101021226900014br.gov.bcb.pix2568qrcodepix.bb.com.br/pix/v2/cobv/771d89f3-73a7-4e39-829d-ef4fb7615db75204000053039865802BR5925FUNDACAO CHESF DE ASSISTE6008BRASILIA62070503***6304";
        crc16.update(input.getBytes());
        String vCRC16final = String.format("%04X", crc16.getCRC());
        System.out.println(input.concat(vCRC16final));
    }
}
