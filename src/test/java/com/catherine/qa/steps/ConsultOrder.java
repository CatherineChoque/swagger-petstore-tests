package com.catherine.qa.steps;

import com.catherine.qa.model.Order;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ConsultOrder {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    public Response response;

    @Step("Consultar orden con id {0}")
    public void consultarOrdenPorId(int id) {
        response = SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get(BASE_URL + "/store/order/" + id)
                .then()
                .log().all()
                .extract().response();
    }

    @Step("Validar código de respuesta {0}")
    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @Step("Mostrar datos de la orden consultada")
    public void mostrarDatosOrden() {
        Order orden = response.as(Order.class);
        System.out.println("########################");
        System.out.println("Id: " + orden.getId());
        System.out.println("PetId: " + orden.getPetId());
        System.out.println("Quantity: " + orden.getQuantity());
        System.out.println("ShipDate: " + orden.getShipDate());
        System.out.println("Status: " + orden.getStatus());
        System.out.println("Complete: " + orden.isComplete());
        System.out.println("########################");
    }
}
