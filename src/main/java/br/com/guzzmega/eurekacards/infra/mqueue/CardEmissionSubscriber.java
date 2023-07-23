package br.com.guzzmega.eurekacards.infra.mqueue;

import br.com.guzzmega.eurekacards.domain.Card;
import br.com.guzzmega.eurekacards.domain.CardCustomer;
import br.com.guzzmega.eurekacards.domain.CardEmission;
import br.com.guzzmega.eurekacards.infra.repository.CardCustomerRepository;
import br.com.guzzmega.eurekacards.infra.repository.CardRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CardEmissionSubscriber {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private CardCustomerRepository cardCustomerRepository;

	@RabbitListener(queues = "${mq.queues.card-emission}")
	public void receiveCardRequest(@Payload String payload){
		try{
			CardEmission cardEmission = new ObjectMapper().readValue(payload, CardEmission.class);
			Card card = cardRepository.findById(cardEmission.getIdCard()).orElseThrow();

			cardCustomerRepository.save(new CardCustomer(card, cardEmission.getDocument(), cardEmission.getBasicLimit()));
		} catch(Exception ex){
			log.error("An error occurred while receiving the card issue request: {}", ex.getMessage());
		}
	}
}