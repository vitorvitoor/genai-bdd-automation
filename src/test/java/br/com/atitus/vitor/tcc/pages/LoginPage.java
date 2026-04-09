package br.com.atitus.vitor.tcc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By campoUsuario = By.id("user-name");
    private final By  campoSenha = By.id("password");
    private final By  botaoEntrar = By.id("login-button");
    private final By  mensagemErro = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherEmail(String usuario) {
        driver.findElement(campoUsuario).sendKeys(usuario);
    }

    public void preencherSenha(String senha) {
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clicarEntrar() {
        driver.findElement(botaoEntrar).click();
    }

    public String obterMensagemErro() {
        try {
            return driver.findElement(mensagemErro).getText();
        } catch (Exception e) {
            return "";
        }
    }
}