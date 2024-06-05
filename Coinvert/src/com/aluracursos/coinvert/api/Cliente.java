package com.aluracursos.coinvert.api;

import com.aluracursos.coinvert.ExchangeRate;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Cliente {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/9e13023896c3fbd91319eb1f/pair/";
    private final HttpClient client;
    private final Gson gson;

    public Cliente(Gson gson) {
        this.client = HttpClient.newHttpClient();
        this.gson = gson;
    }

    public ExchangeRate getExchangeRate(String base, String target) throws IOException, InterruptedException {
        String url = API_URL + base + "/" + target;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), ExchangeRate.class);
    }
}

