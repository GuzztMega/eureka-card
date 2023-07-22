package br.com.guzzmega.eurekacards.service;

import br.com.guzzmega.eurekacards.domain.Card;
import br.com.guzzmega.eurekacards.infra.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardService {

	@Autowired
	private CardRepository repository;

	@Transactional
	public Card save(Card object){
		return repository.save(object);
	}

	public Optional<Card> getCardById(UUID id){
		return repository.findById(id);
	}

	public List<Card> getCardsByIncome(Long income){
		return repository.findByIncomeLessThanEqual(BigDecimal.valueOf(income));
	}
}
