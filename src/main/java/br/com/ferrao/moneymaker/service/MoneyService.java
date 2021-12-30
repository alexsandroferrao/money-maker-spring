package br.com.ferrao.moneymaker.service;

import br.com.ferrao.moneymaker.entity.MoneyDto;
import br.com.ferrao.moneymaker.models.AnimalModel;
import br.com.ferrao.moneymaker.repository.MoneyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MoneyService {
    @Autowired
    private MoneyRepository moneyRepository;

    public Long saveMoney(AnimalModel animalModel){
        MoneyDto moneyDto = new MoneyDto(System.nanoTime(), 10.00, animalModel.getNome());
        moneyRepository.save(moneyDto);
        return moneyDto.getId();
    }

    public Optional<MoneyDto> getMoney(Long idMoney){
        return moneyRepository.findById(idMoney);
    }

    public List<MoneyDto> getAllMoney() {
        return moneyRepository.findAll();
    }
}
