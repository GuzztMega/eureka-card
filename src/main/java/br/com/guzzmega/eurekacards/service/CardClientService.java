package br.com.guzzmega.eurekacards.service;

import br.com.guzzmega.eurekacards.domain.Card;
import br.com.guzzmega.eurekacards.domain.CardClient;
import br.com.guzzmega.eurekacards.infra.Repository.CardClientRepository;
import br.com.guzzmega.eurekacards.infra.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CardClientService {

	@Autowired
	private CardClientRepository repository;

	public List<CardClient> getCardsByDocument(String document){
		return repository.findByDocument(document);
	}
}
