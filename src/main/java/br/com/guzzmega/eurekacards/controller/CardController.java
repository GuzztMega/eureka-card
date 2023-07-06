package br.com.guzzmega.eurekacards.controller;

import br.com.guzzmega.eurekacards.domain.Card;
import br.com.guzzmega.eurekacards.dto.CardDTO;
import br.com.guzzmega.eurekacards.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("cards")
public class CardController {

	@Autowired
	private CardService service;

	@GetMapping("/health")
	public String status(){
		log.info("Checking cards microservice status...");
		return "Application Status: UP!";
	}

	@PostMapping
	public ResponseEntity<Card> save(@RequestBody CardDTO objectDto){
		var object = new Card();
		BeanUtils.copyProperties(objectDto, object);
		service.save(object);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping(params = "income")
	public ResponseEntity<List<Card>> getCardByIncome(@RequestParam("income") Long income){
		List<Card> cardList = service.getCardsByIncome(income);
		return ResponseEntity.ok(cardList);
	}
}