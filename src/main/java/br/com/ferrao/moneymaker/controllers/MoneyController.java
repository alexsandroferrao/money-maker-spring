package br.com.ferrao.moneymaker.controllers;

import br.com.ferrao.moneymaker.models.AnimalModel;
import br.com.ferrao.moneymaker.models.MoneyModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/moneys")
public class MoneyController {

    @PostMapping
    public ResponseEntity<MoneyModel> postMoney(AnimalModel animalModel){
        return ResponseEntity.created(URI.create("criado")).build();
    }

    @GetMapping
    public ResponseEntity<MoneyModel> getMoney(){
        return ResponseEntity.ok().build();
    }
}
