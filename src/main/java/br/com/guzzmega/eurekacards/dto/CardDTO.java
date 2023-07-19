package br.com.guzzmega.eurekacards.dto;

import br.com.guzzmega.eurekacards.domain.CardBrand;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardDTO {

	private String name;
	private CardBrand cardBrand;
	private BigDecimal income;
	private BigDecimal basicLimit;

}
