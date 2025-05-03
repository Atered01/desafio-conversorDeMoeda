package com.conversormoedas.api;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverterService {

    public static Double curencyApi(String moedaOrigin, String moedaDestino) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/9d93ec5f16a52b38307c467f/pair/" + moedaOrigin + "/" + moedaDestino))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                String json = response.body();
                Formatada retorno = gson.fromJson(json, Formatada.class);
                return retorno.conversion_rate();
            }else{
                System.err.println("Erro ao obter taxa de cambio. Código de status:  " + response.statusCode());
                return null;
            }
        } catch (IOException e) {
            System.err.println("Erro de E/S ao conectar à API: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            System.err.println("Thread interrompida durante a conexão à API: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Erro inesperadp: " + e.getMessage());
            return null;
        }
    }
}
