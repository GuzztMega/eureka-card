package br.com.guzzmega.eurekacards.infra.repository;

import br.com.guzzmega.eurekacards.domain.CardClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardClientRepository extends JpaRepository<CardClient, UUID> {
	List<CardClient> findByDocument(String document);
}
