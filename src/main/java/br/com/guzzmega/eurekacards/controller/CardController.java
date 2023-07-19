package br.com.guzzmega.eurekacards.controller;

import br.com.guzzmega.eurekacards.domain.Card;
import br.com.guzzmega.eurekacards.domain.CardClient;
import br.com.guzzmega.eurekacards.dto.CardClientDTO;
import br.com.guzzmega.eurekacards.dto.CardDTO;
import br.com.guzzmega.eurekacards.service.CardClientService;
import br.com.guzzmega.eurekacards.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("cards")
public class CardController {

	@Autowired
	private CardService cardService;

	@Autowired
	private CardClientService cardClientservice;

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

	@GetMapping(params = "document")
	public ResponseEntity<List<CardClientDTO>> getCardByClient(@RequestParam("document") String document){
		List<CardClient> cardClientList = cardClientservice.getCardsByDocument(document);
		List<CardClientDTO> cardClientDTOList = cardClientList.stream().map(CardClientDTO::new).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(cardClientDTOList);
	}
}