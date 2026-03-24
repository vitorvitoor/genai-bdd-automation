package br.com.atitus.vitor.tcc;

import br.com.atitus.vitor.tcc.utils.LLMClient;

public class TesteIA {
    public static void main(String[] args) {
        try {
            LLMClient cliente = new LLMClient();
            System.out.println("Iniciando Orquestrador...");

            String prompt = """
            PAPEL: Atue como um Engenheiro de QA Sênior especialista em BDD e Gherkin.
            
            CONTEXTO: Use o seguinte Requisito de Alto Nível (Tabela 1):
            - Sistema: Nexus (Módulo de Autenticação)
            - User Story: Usuário registrado acessa com e-mail e senha.
            - Regras: E-mail formatado (nome@dominio.com), Senha de 6 a 12 caracteres.
            - Bloqueio: 3 tentativas falhas em 24h geram bloqueio permanente.
            - Borda: Se campos vazios, priorizar erro de obrigatoriedade sobre o de formato.
            - Seletores: data-test para campos e btn-primary para o botão.
            
            TAREFA: Gere uma lista de cenários Gherkin (em Português) cobrindo:
            1. Caminho Feliz (Login com sucesso).
            2. Fluxo de Exceção (E-mail inválido).
            3. Fluxo de Exceção (Senha fora do limite).
            4. Cenário de Borda (Campos vazios).
            5. Cenário Crítico (Bloqueio após 3 tentativas).
            
            SAÍDA ESPERADA: Apenas o texto formatado do arquivo .feature.
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