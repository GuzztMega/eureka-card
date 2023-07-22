package br.com.guzzmega.eurekacards.service;

import br.com.guzzmega.eurekacards.domain.CardCustomer;
import br.com.guzzmega.eurekacards.infra.repository.CardCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardCustomerService {

	@Autowired
	private CardCustomerRepository repository;

	public List<CardCustomer> getCardsByDocument(String document){
		return repository.findByDocument(document);
	}
}
