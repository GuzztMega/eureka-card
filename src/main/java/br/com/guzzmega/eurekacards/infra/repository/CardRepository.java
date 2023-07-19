package br.com.guzzmega.eurekacards.infra.repository;

import br.com.guzzmega.eurekacards.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {

	List<Card> findByIncomeLessThanEqual(BigDecimal bigDecimal);
}
