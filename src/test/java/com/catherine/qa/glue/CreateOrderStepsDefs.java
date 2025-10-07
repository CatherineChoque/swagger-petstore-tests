package com.catherine.qa.glue;

import com.catherine.qa.steps.CreateOrder;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class CreateOrderStepsDefs {
    @Steps
    CreateOrder createOrder;

    @Given("estoy en la pagina de mascota")
    public void estoyEnLaPaginaDeMascota() {
    }

    @When("creo una orden con el id {int}, petId {int} y quantity {int}")
    public void creoUnaOrdenConElIdPetIdYQuantity(int id, int petId, int quantity) {
        String shipDate = java.time.Instant.now().toString();
        String status = "placed";
        boolean complete = true;
        createOrder.createOrder(id, petId, quantity, shipDate, status,complete);
    }

    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
        createOrder.validarCodigoRespuesta(statusCode);
    }

}
