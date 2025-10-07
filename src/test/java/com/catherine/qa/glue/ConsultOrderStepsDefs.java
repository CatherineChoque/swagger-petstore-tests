package com.catherine.qa.glue;

import com.catherine.qa.steps.ConsultOrder;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class ConsultOrderStepsDefs {
    @Steps
    ConsultOrder consultOrder;

    @When("consulto la orden con id {int}")
    public void consultoLaOrdenConId(int id) {
        consultOrder.consultarOrdenPorId(id);
    }

    @Then("el código de la respuesta es {int}")
    public void elCódigoDeLaRespuestaEs(int statusCode) {
        consultOrder.validarCodigoRespuesta(statusCode);
    }
}
