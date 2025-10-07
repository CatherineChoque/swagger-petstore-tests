package com.catherine.qa;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"com.catherine"},
        features = "classpath:features",
        tags = "@test1"   //  ==> Definir el @tag  a ejecutar
)
public class CucumberTestSuite {
}