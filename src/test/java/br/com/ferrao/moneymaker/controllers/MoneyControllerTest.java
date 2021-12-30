package br.com.ferrao.moneymaker.controllers;

import br.com.ferrao.moneymaker.models.AnimalModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

@WebMvcTest
class MoneyControllerTest {

    @Autowired
    private MoneyController moneyController;

    @BeforeEach
    void setup(){
        standaloneSetup(moneyController);
    }

    @Test
    void deveSerPossivelCriarMoney(){
        AnimalModel animal = new AnimalModel("Leao");
        given().
                contentType(JSON).body(animal).
        when().
                post("/moneys").
        then().statusCode(SC_CREATED);
    }

    @Test
    void deveSerPossivelBuscarMoney(){
        given().
                contentType(JSON).
                when().
                get("/moneys").
                then().statusCode(SC_OK);
    }
}
