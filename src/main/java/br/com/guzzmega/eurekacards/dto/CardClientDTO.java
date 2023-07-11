package br.com.guzzmega.eurekacards.dto;

import br.com.guzzmega.eurekacards.domain.CardClient;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardClientDTO {

	private String name;
	private String brand;
	private BigDecimal incomeLimit;

	public CardClientDTO(CardClient cardClient) {
		this.name = cardClient.getCard().getName();
		this.brand = cardClient.getCard().getCardBrand().toString();
		this.incomeLimit = cardClient.getCardLimit();
	}
}
