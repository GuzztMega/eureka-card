package br.com.guzzmega.eurekacards.dto;

import br.com.guzzmega.eurekacards.domain.Card;
import br.com.guzzmega.eurekacards.domain.CardBrand;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardDTO {

	private String name;
	private CardBrand cardBrand;
	private BigDecimal income;
	private BigDecimal basicLimit;

	public CardDTO(){
	}

	public CardDTO(Card card){
		this.name = card.getName();
		this.cardBrand = card.getCardBrand();
		this.income = card.getIncome();
		this.basicLimit = card.getBasicLimit();
	}
}
