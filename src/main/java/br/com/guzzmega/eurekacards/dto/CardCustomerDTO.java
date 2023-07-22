package br.com.guzzmega.eurekacards.dto;

import br.com.guzzmega.eurekacards.domain.CardCustomer;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardCustomerDTO {

	private String name;
	private String cardBrand;
	private BigDecimal basicLimit;

	public CardCustomerDTO(CardCustomer cardCustomer) {
		this.name = cardCustomer.getCard().getName();
		this.cardBrand = cardCustomer.getCard().getCardBrand().toString();
		this.basicLimit = cardCustomer.getCardLimit();
	}
}
