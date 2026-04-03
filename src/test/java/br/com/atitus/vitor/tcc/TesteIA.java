package br.com.atitus.vitor.tcc;

import br.com.atitus.vitor.tcc.utils.LLMClient;

public class TesteIA {
    public static void main(String[] args) {
        try {
            LLMClient cliente = new LLMClient();
            System.out.println("Iniciando Orquestrador...");

            String prompt = """
            PAPEL: Atue como Analista de QA Sênior especialista em Automação.
            
            TAREFA: Converta os Gherkins fornecidos em uma Tabela de Planejamento de Testes (Markdown).
            
            ENTRADA BDD:
            1. Login Sucesso: Dado que estou na tela de login, insiro credenciais válidas e clico em entrar.
            2. Formato Inválido: Dado que insiro e-mail sem '@', recebo erro de formato.
            3. Bloqueio Permanente: Dado que erro a senha 3 vezes, a conta é bloqueada permanentemente.
            
            DADOS TÉCNICOS OBRIGATÓRIOS:
            - Campos: [data-test='email-input'] e [data-test='password-input']
            - Botão: [btn-primary=login-button]
            
            FORMATO DA TABELA (Saída):
            | ID | Cenário | Ações Detalhadas (Passo a Passo) | Resultado Esperado |
            |---|---|---|---|
            | CT-001 | Sucesso | ... | ... |
            
            REGRAS: Gere APENAS a tabela Markdown para estes 3 cenários. Seja conciso e direto.
            """;

            String resposta = cliente.enviarPrompt(prompt);

            System.out.println("--------------------------------------");
            System.out.println("RESPOSTA DA IA: " + resposta.trim());
            System.out.println("--------------------------------------");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}