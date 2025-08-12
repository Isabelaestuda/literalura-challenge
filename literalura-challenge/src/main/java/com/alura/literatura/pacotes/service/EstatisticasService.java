package com.alura.literatura.pacotes.service;


import com.alura.literatura.pacotes.model.Livro;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.alura.literatura.pacotes.repository.LivroRepository;



import java.util.Map;

import java.util.stream.Collectors;



@Service



public class EstatisticasService {



     @Autowired

     private LivroRepository livroRepository;



     public void mostrarQuantidadeLivrosPorIdioma() {

         var livros = livroRepository.findAll();



         Map<String, Long> contagemPorIdioma = livros.stream()

                 .filter(l -> l.getIdioma() != null && !l.getIdioma().isBlank())

                 .collect(Collectors.groupingBy(Livro::getIdioma, Collectors.counting()));



         var idiomasComDoisOuMais = contagemPorIdioma.entrySet().stream()

                                 .filter(e -> e.getValue() >= 2)

                                 .toList();



         if (idiomasComDoisOuMais.isEmpty()) {

             System.out.println("Nenhum idioma com 2 ou mais livros encontrados.");

         } else {

             System.out.println("Quantidade de livros por idioma (2 ou mais):");

             idiomasComDoisOuMais.forEach(e ->

                                         System.out.println("Idioma: " + e.getKey() + " - Quantidade: " + e.getValue()));

        }

 }











}



