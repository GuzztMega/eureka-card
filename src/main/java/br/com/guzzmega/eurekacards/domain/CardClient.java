package br.com.guzzmega.eurekacards.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class CardClient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String document;
	private BigDecimal cardLimit;

	@ManyToOne
	@JoinColumn(name = "idCard")
	private Card card;

	public CardClient(){
	}
}