package br.com.guzzmega.eurekacards.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CardEmission {
	private UUID idCard;
	private String document;
	private String address;
	private BigDecimal basicLimit;

	public String toString(){
		return "IDCARD: " + getIdCard()
				+ ", Document: " + getDocument()
				+ ", Address: " + getAddress()
				+ ", BasicLimit: " + getBasicLimit();
	}
}
