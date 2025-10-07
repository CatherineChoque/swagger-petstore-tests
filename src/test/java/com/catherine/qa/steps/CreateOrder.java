package com.catherine.qa.steps;

import com.catherine.qa.model.Order;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateOrder {
    private static String BASE_URL = "https://petstore.swagger.io/v2";
    public Order order;
    @Step("Crear orden en PetStore")
    public void createOrder(int id, int petId, int quantity, String shipDate, String status, boolean complete){
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"petId\": " + petId + ",\n" +
                        "  \"quantity\": " + quantity + ",\n" +
                        "  \"shipDate\": \"" + shipDate + "\",\n" +
                        "  \"status\": \"" + status + "\",\n" +
                        "  \"complete\": " + complete + "\n" +
                        "}")
                .log().all()
                .post(BASE_URL + "/store/order")
                .then()
                .log().all();

    }

    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }
}
