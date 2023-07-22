package br.com.guzzmega.eurekacards.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class CardCustomer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String document;
	private BigDecimal cardLimit;

	@ManyToOne
	@JoinColumn(name = "idCard")
	private Card card;

	public CardCustomer(){
	}

	public CardCustomer(Card card, String document, BigDecimal cardLimit){
		this.card = card;
		this.document = document;
		this.cardLimit = cardLimit;
	}

	public String toString(){
		return "ID: " + getId()
				+ ", Document: " + getDocument()
				+ ", CardLimit: " + getCardLimit()
				+ ", Card: { " + getCard().toString() + "} ";
	}
}