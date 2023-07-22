package br.com.guzzmega.eurekacards.infra.repository;

import br.com.guzzmega.eurekacards.domain.CardCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardCustomerRepository extends JpaRepository<CardCustomer, UUID> {
	List<CardCustomer> findByDocument(String document);
}
