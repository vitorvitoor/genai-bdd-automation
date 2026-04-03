package br.com.atitus.vitor.tcc.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LLMClient {
    private static final String API_KEY = System.getenv("GEMINI_API_KEY");
    private static final String URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + API_KEY;

    public LLMClient() {
        if (API_KEY == null || API_KEY.isEmpty()) {
            throw new RuntimeException("ERRO: Variável de ambiente GEMINI_API_KEY não configurada no Windows!");
        }
    }

    public String enviarPrompt(String promptEnvio) {
        try {
            // Escapamento rigoroso para JSON (incluindo aspas e quebras de linha)
            String promptFormatado = promptEnvio
                    .replace("\\", "\\\\")
                    .replace("\"", "\\\"")
                    .replace("\n", "\\n")
                    .replace("\r", "");

            String jsonBody = """
            {
              "contents": [{
                "parts":[{
                  "text": "%s"
                }]
              }],
              "generationConfig": {
                "temperature": 0.2,
                "maxOutputTokens": 4096,\s
                "topK": 40,
                "topP": 0.95
              }
            }
           \s""".formatted(promptFormatado);

            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(java.time.Duration.ofSeconds(20))
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
                return jsonResponse.getAsJsonArray("candidates")
                        .get(0).getAsJsonObject()
                        .getAsJsonObject("content")
                        .getAsJsonArray("parts")
                        .get(0).getAsJsonObject()
                        .get("text").getAsString();
            } else {
                return "Erro API (" + response.statusCode() + "): " + response.body();
            }
        } catch (Exception e) {
            return "Erro na requisição: " + e.getMessage();
        }
    }
}