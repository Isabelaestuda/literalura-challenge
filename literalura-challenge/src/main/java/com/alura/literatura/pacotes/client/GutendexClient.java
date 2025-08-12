package com.alura.literatura.pacotes.client;


import java.net.URI;

import java.net.http.HttpClient;

import java.net.http.HttpRequest;

import java.net.http.HttpResponse;



import com.fasterxml.jackson.databind.ObjectMapper;

import com.alura.literatura.pacotes.dto.LivroDTO;



public class GutendexClient {

   private final HttpClient client = HttpClient.newHttpClient();



   public String buscarLivroPorTitulo(String titulo) {

       try {

           URI uri = URI.create("https://gutendex.com/books/?search=" + titulo.replace(" ", "+"));

           HttpRequest request = HttpRequest.newBuilder()

                                       .uri(uri)

                                       .GET()

                                       .build();



           HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

           return response.body();

       } catch (Exception e) {

           e.printStackTrace();

           return null;

       }

   }



   public LivroDTO buscarPrimeiroLivro(String titulo) {

       try {

           String json = buscarLivroPorTitulo(titulo);

           ObjectMapper mapper = new ObjectMapper();

           var root = mapper.readTree(json);

           var firstBook = root.get("results").get(0);

           return mapper.treeToValue(firstBook, LivroDTO.class);

       } catch (Exception e) {

           e.printStackTrace();

           return null;

       }

   }

}







