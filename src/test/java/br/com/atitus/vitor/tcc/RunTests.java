package br.com.atitus.vitor.tcc;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Localização dos arquivos Gherkin (.feature) gerados pela IA
        features = "src/test/resources/features",

        // Pacote onde estão as classes Step Definition (IA e Manual)
        glue = "br.com.atitus.vitor.tcc.stepdefinitions",

        // Gera relatórios visuais
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },

        // Garante que as mensagens no console usem termos em português
        monochrome = true,

        // Mapeia os steps sem executar (útil para validar se a IA gerou nomes corretos)
        dryRun = false
)
public class RunTests {
    // Esta classe serve apenas como gatilho para o JUnit
}