package br.com.guzzmega.eurekacards.controller;

import br.com.guzzmega.eurekacards.domain.Card;
import br.com.guzzmega.eurekacards.domain.CardCustomer;
import br.com.guzzmega.eurekacards.dto.CardCustomerDTO;
import br.com.guzzmega.eurekacards.dto.CardDTO;
import br.com.guzzmega.eurekacards.service.CardCustomerService;
import br.com.guzzmega.eurekacards.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("cards")
public class CardController {

	@Autowired
	private CardService cardService;

	@Autowired
	private CardCustomerService cardClientService;

	@GetMapping("/health")
	public String status(){
		log.info("Checking cards microservice status...");
		return "Cards Application Status: UP!";
	}

	@PostMapping
	public ResponseEntity<Card> save(@RequestBody CardDTO objectDto){
		var object = new Card();
		BeanUtils.copyProperties(objectDto, object);
		cardService.save(object);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping(params = "income")
	public ResponseEntity<List<Card>> getCardByIncome(@RequestParam("income") Long income){
		List<Card> cardList = cardService.getCardsByIncome(income);

		return ResponseEntity.ok(cardList);
	}


	@GetMapping(params = "id")
	public ResponseEntity<CardDTO> getCardById(@RequestParam("id") UUID id){
		Optional<Card> optional = cardService.getCardById(id);
		if(optional.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(new CardDTO(optional.get()));

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping(params = "document")
	public ResponseEntity<List<CardCustomerDTO>> getCardByCustomer(@RequestParam("document") String document){
		List<CardCustomer> cardCustomerList = cardClientService.getCardsByDocument(document);
		List<CardCustomerDTO> cardCustomerDTOList = cardCustomerList.stream().map(CardCustomerDTO::new).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(cardCustomerDTOList);
	}
}