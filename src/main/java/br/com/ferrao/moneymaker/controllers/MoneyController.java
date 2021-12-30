package br.com.ferrao.moneymaker.controllers;

import br.com.ferrao.moneymaker.entity.MoneyDto;
import br.com.ferrao.moneymaker.models.AnimalModel;
import br.com.ferrao.moneymaker.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/moneys")
public class MoneyController {

    @Autowired
    private MoneyService moneyService;

    @PostMapping
    public ResponseEntity<MoneyDto> postMoney(@RequestBody AnimalModel animalModel) {
        Long idMoney = moneyService.saveMoney(animalModel);
        return ResponseEntity.created(URI.create(idMoney.toString())).build();
    }

    @GetMapping("/{moneyId}")
    public ResponseEntity<MoneyDto> getMoney(@PathVariable(value = "moneyId") Long moneyId) {
        Optional<MoneyDto> moneyOpt = moneyService.getMoney(moneyId);
        return moneyOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping()
    public List<MoneyDto> getMoney() {
        return moneyService.getAllMoney();
    }
}
