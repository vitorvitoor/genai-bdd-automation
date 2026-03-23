package br.com.atitus.vitor.tcc;

import br.com.atitus.vitor.tcc.utils.LLMClient;

public class TesteIA {
    public static void main(String[] args) {
        try {
            LLMClient cliente = new LLMClient();
            System.out.println("Iniciando Orquestrador - Fase de Preparação...");

            String prompt = "Diga: 'Conexão com o TCC de Vítor estabelecida com sucesso!'";
            String resposta = cliente.enviarPrompt(prompt);

            System.out.println("--------------------------------------");
            System.out.println("RESPOSTA DA IA: " + resposta.trim());
            System.out.println("--------------------------------------");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}