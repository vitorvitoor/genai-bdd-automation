package br.com.atitus.vitor.tcc;

import br.com.atitus.vitor.tcc.utils.LLMClient;

public class TesteIA {
    public static void main(String[] args) {
        try {
            LLMClient cliente = new LLMClient();
            System.out.println("Iniciando Orquestrador...");

            String prompt = """
                PAPEL: Engenheiro de Automação de Testes Sênior especializado em Java e Selenium.
                
                CONTEXTO TÉCNICO (Stack do TCC):
                - Linguagem: Java 17.
                - Frameworks: Selenium 4, Cucumber (pt), JUnit 4 (org.junit.Assert).
                - Padrão: Page Object Model (POM).
                - Pacote: br.com.atitus.vitor.tcc.stepdefinitions.
                
                REFERÊNCIA DA CLASSE DE PÁGINA (LoginPage.java):
                - Métodos disponíveis: preencherEmail(String), preencherSenha(String), clicarEntrar(), obterMensagemErro().
                
                ENTRADA (Casos de Teste da Fase 2):
                | ID | Cenário | Ações | Resultado Esperado |
                |---|---|---|---|
                | CT-001 | Sucesso | Aceder SauceDemo, preencher 'standard_user' e 'secret_sauce', clicar em 'login-button' | Login realizado (sem erro) |
                | CT-002 | Bloqueio | Preencher 'locked_out_user' e 'secret_sauce', clicar em 'login-button' | Mensagem 'Locked out' exibida |
                | CT-003 | Borda | Deixar usuário vazio, preencher senha, clicar em 'login-button' | Mensagem 'Username is required' exibida |
                
                TAREFA:
                Gere a classe 'LoginIA_Steps.java'. Regras:
                1. Importe a LoginPage de 'br.com.atitus.vitor.tcc.pages.LoginPage'.
                2. Use JUnit 4 para asserções (Assert.assertTrue).
                3. Use @Dado, @Quando, @Então em Português.
                4. Garanta que o WebDriver é fechado no final (driver.quit).
                
                SAÍDA: Apenas o código Java puro.
                """;

            // --- INÍCIO DO CRONÔMETRO ---
            long startTime = System.currentTimeMillis();

            String resposta = cliente.enviarPrompt(prompt);

            long endTime = System.currentTimeMillis();
            // --- FIM DO CRONÔMETRO ---

            double tempoSegundos = (endTime - startTime) / 1000.0;

            System.out.println("--------------------------------------");
            System.out.println("RESPOSTA DA IA: " + resposta.trim());
            System.out.println("--------------------------------------");

            // LINHA ADICIONADA PARA RESOLVER O PROBLEMA:
            System.out.printf("TEMPO DE GERAÇÃO: %.2f segundos%n", tempoSegundos);
            System.out.println("--------------------------------------");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}