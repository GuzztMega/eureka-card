package br.com.guzzmega.eurekacards.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String name;
	private BigDecimal income;
	private BigDecimal basicLimit;
	@Enumerated(EnumType.STRING)
	private CardBrand cardBrand;

	public Card(){

	}

	public Card(String name, BigDecimal income, BigDecimal basicLimit, CardBrand cardBrand){
		this.name = name;
		this.income = income;
		this.basicLimit = basicLimit;
		this.cardBrand = cardBrand;
	}

	public Card(UUID id, String name, BigDecimal income, BigDecimal basicLimit, CardBrand cardBrand){
		this.id = id;
		this.name = name;
		this.income = income;
		this.basicLimit = basicLimit;
		this.cardBrand = cardBrand;
	}
}
