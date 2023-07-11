package br.com.guzzmega.eurekacards.domain;

import br.com.guzzmega.eurekacards.infra.Repository.CardRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class CardTest {

	private Card card;

	@Mock
	private CardRepository cardRepository;

	@Before
	public void setup() {
		// Given
		UUID id = UUID.randomUUID();
		String name = "Augusto Longo";
		BigDecimal income = BigDecimal.valueOf(5000);
		BigDecimal basicLimit = BigDecimal.valueOf(2000);
		CardBrand cardBrand = CardBrand.VISA;

		card = new Card(id, name, income, basicLimit, cardBrand);
	}

	@Test
	public void testCardCreation() {
		// When
		UUID id = card.getId();
		String name = "Augusto Longo";
		BigDecimal income = BigDecimal.valueOf(5000);
		BigDecimal basicLimit = BigDecimal.valueOf(2000);
		CardBrand cardBrand = CardBrand.VISA;

		// Then
		// Verifica se os atributos foram definidos corretamente
		Assert.assertEquals(id, card.getId());
		Assert.assertEquals(name, card.getName());
		Assert.assertEquals(income, card.getIncome());
		Assert.assertEquals(basicLimit, card.getBasicLimit());
		Assert.assertEquals(cardBrand, card.getCardBrand());
	}

	@Test
	public void testSaveCard() {
		// Given
		// Configura o comportamento do mock do repository
		Mockito.when(cardRepository.save(Mockito.any(Card.class))).thenReturn(card);

		// When
		// Chama o método a ser testado
		Card savedCard = cardRepository.save(card);

		// Then
		// Verifica se o método save do repository foi chamado corretamente
		Mockito.verify(cardRepository).save(card);
		Assert.assertEquals(card, savedCard);
	}

	@Test
	public void testSetNewCardLimit() {
		// Given
		// Define um novo limite para o cartão
		BigDecimal newLimit = BigDecimal.valueOf(3000);

		// When
		// Chama o método a ser testado
		card.setBasicLimit(newLimit);

		// Then
		// Verifica se o novo limite foi atualizado corretamente
		Assert.assertEquals(newLimit, card.getBasicLimit());
	}
}