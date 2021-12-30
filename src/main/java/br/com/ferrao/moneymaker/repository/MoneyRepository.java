package br.com.ferrao.moneymaker.repository;

import br.com.ferrao.moneymaker.entity.MoneyDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyRepository extends JpaRepository<MoneyDto,Long> {
}
