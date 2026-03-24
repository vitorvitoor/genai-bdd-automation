package br.com.atitus.vitor.tcc.stepdefinitions;

import br.com.atitus.vitor.tcc.pages.LoginPage;
import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private WebDriver driver = new ChromeDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Dado("que eu estou na página de login")
    public void que_eu_estou_na_pagina_de_login() {
        driver.get("https://nexus-login-demo.com"); // URL fictícia do projeto
    }

    @Quando("eu insiro um e-mail inválido")
    public void eu_insiro_um_e_mail_inválido() {
        loginPage.preencherEmail("invalido.com");
    }

    @Entao("o sistema deve exibir uma mensagem de erro de formato")
    public void o_sistema_deve_exibir_mensagem_erro() {
        assertTrue(loginPage.obterMensagemErro().contains("E-mail inválido"));
        driver.quit();
    }
}