package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCotacao {

    public Cotacao minhaBusca(String primeiraSigla, String segundaSigla) {
        String link = "https://v6.exchangerate-api.com/v6/a2e1276294eac61b27c0c62c/pair/"
                + primeiraSigla + "/" + segundaSigla;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Cotacao.class);

        } catch (RuntimeException | IOException | InterruptedException e) {
            throw new RuntimeException("Apartir dessa sigla informada não foi possivel ter a resposta");
        }
    }
}
