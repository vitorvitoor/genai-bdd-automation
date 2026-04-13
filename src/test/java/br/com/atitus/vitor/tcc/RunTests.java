package br.com.atitus.vitor.tcc;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "br.com.atitus.vitor.tcc.stepdefinitions",
        // Gera relatórios visuais
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        // Garante que as mensagens no console usem termos em português
        monochrome = true,
        // Mapeia os steps sem executar
        dryRun = false
)
public class RunTests {
    // Essa classe serve apenas como gatilho para o JUnit
}