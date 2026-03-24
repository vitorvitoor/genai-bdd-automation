package br.com.atitus.vitor.tcc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Seletores baseados na Tabela 1 do Requisito
    private By campoEmail = By.cssSelector("[data-test='email']");
    private By campoSenha = By.cssSelector("[data-test='password']");
    private By botaoEntrar = By.className("btn-primary");
    private By mensagemErro = By.id("error-message");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherEmail(String email) {
        driver.findElement(campoEmail).sendKeys(email);
    }

    public void preencherSenha(String senha) {
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clicarEntrar() {
        driver.findElement(botaoEntrar).click();
    }

    public String obterMensagemErro() {
        return driver.findElement(mensagemErro).getText();
    }
}