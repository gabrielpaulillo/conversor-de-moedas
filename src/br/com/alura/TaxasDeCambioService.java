package br.com.alura;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TaxasDeCambioService {
//    Método público (pode ser acessado de fora da classe) que retorna um objeto da classe "TaxasDeCambio".
    public TaxasDeCambio obterTaxasDeCambio() throws IOException, InterruptedException {
//         Cria uma instância do HttpClient para fazer requisições HTTP
        HttpClient client = HttpClient.newHttpClient();

//         Constrói uma requisição HTTP para a URL da API de taxas de câmbio
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/97ef2026b17117a1df4e2fca/latest/BRL"))
                .build();

//         Envia a requisição e obtém a resposta como uma string
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

//         Cria uma instância do Gson para converter objetos Java em formato JSON
        Gson gson = new GsonBuilder()
                .setPrettyPrinting() // Formata a saída de forma legível
                .create();

//         Converte a string da resposta JSON em um objeto TaxasDeCambio usando o Gson
        return gson.fromJson(response.body(), TaxasDeCambio.class);
    }
}
