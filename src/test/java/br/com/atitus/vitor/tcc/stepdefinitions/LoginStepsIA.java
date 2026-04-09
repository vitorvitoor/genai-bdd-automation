package br.com.atitus.vitor.tcc.stepdefinitions;

import br.com.atitus.vitor.tcc.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class LoginStepsIA {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
    }

    @After
    public void teardown() {
        if (driver != null) { driver.quit(); }
    }

    @Dado("que estou na página de login do Swag Labs")
    public void que_estou_na_pagina_de_login() {
        driver.get("https://www.saucedemo.com/");
    }

    @Quando("preencho o campo {string} com {string}")
    public void preencho_o_campo_com(String campo, String valor) {
        if (campo.contains("user-name")) {
            loginPage.preencherEmail(valor);
        } else {
            loginPage.preencherSenha(valor);
        }
    }

    @Quando("deixo o campo {string} vazio")
    public void deixo_o_campo_vazio(String campo) {
        loginPage.preencherEmail("");
    }

    @Quando("clico no botão {string}")
    public void clico_no_botao(String botao) {
        loginPage.clicarEntrar();
    }

    @Então("devo ser direcionado para a página de inventário")
    public void devo_ser_direcionado_para_a_pagina_de_inventario() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Então("devo ver a mensagem de erro {string}")
    public void devo_ver_a_mensagem_de_erro(String mensagemEsperada) {
        String mensagemAtual = loginPage.obterMensagemErro();
        Assert.assertTrue("Erro esperado: " + mensagemEsperada + " mas foi: " + mensagemAtual,
                mensagemAtual.contains(mensagemEsperada));
    }
}