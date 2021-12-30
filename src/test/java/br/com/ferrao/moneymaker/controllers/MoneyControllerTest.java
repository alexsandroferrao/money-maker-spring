package br.com.ferrao.moneymaker.controllers;

import br.com.ferrao.moneymaker.entity.MoneyDto;
import br.com.ferrao.moneymaker.models.AnimalModel;
import br.com.ferrao.moneymaker.service.MoneyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest
class MoneyControllerTest {

    @Autowired
    private MoneyController moneyController;

    @MockBean
    private MoneyService moneyService;

    @BeforeEach
    void setup() {
        standaloneSetup(moneyController);
    }

    @Test
    void deveSerPossivelCriarMoney() {

        AnimalModel animal = new AnimalModel("Leao");
        given().
                contentType(JSON).body(animal).
                when().
                post("/moneys").
                then().statusCode(SC_CREATED);
    }

    @Test
    void deveSerPossivelBuscarMoney() {
        Mockito.when(moneyService.getMoney(1L)).thenReturn(Optional.of(new MoneyDto(1L, 10.00, "Leaozinho")));

        when().
                get("/moneys/1").
                then().
                body("animal", is("Leaozinho"),"valor", is(10.0F)).
                statusCode(SC_OK);
    }

    @Test
    void naoEncontrouNenhumMoney() {
        when().
                get("/moneys/1").
                then().
                statusCode(SC_NOT_FOUND);
    }

    @Test
    void deveSerPossivelAllMoneys() {
        Mockito.when(moneyService.getAllMoney()).thenReturn(List.of(new MoneyDto(1L, 10.00, "Leaozinho"),new MoneyDto(1L, 20.00, "Arara")));

        when().
                get("/moneys").
                then().
                body("animal[0]", is("Leaozinho"),"animal[1]", is("Arara")).
                statusCode(SC_OK);
    }
}
