package br.com.guzzmega.eurekacards.service;

import br.com.guzzmega.eurekacards.domain.CardClient;
import br.com.guzzmega.eurekacards.infra.repository.CardClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardClientService {

	@Autowired
	private CardClientRepository repository;

	public List<CardClient> getCardsByDocument(String document){
		return repository.findByDocument(document);
	}
}
