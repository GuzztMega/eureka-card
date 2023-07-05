//package br.com.guzzmega.eurekacards.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Service
//public class CardService {
//
//	@Autowired
//	private CardRepository repository;
//
//	@Transactional
//	public Card save(Card object){
//		return repository.save(object);
//	}
//
//	public Optional<Card> getByDocument(String document){
//		return repository.findByDocument(document);
//	}
//
//	public List<Card> findAll(){
//		return repository.findAll();
//	}
//}
