package com.alura.literatura.pacotes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonAlias;

import com.fasterxml.jackson.annotation.JsonProperty;



import java.util.List;





@JsonIgnoreProperties(ignoreUnknown = true)



public class LivroDTO {



       @JsonAlias("title")

       private String titulo;



       @JsonAlias("authors")

       private List<AutorDTO> autores;



        @JsonProperty("languages")

        private List<String> idioma;



      //private List<String> idioma;







       @JsonAlias("download_count")

       private int downloads;



       // Getter para o título

       public String getTitulo() {

           return titulo;

       }



       // Getter e setter para autores

       public List<AutorDTO> getAutores() {

           return autores;

       }



       public void setAutores(List<AutorDTO> autores) {

           this.autores = autores;

       }



       // Getter e setter para languages



       public List<String> getIdioma() {

           return idioma;

       }



       public void setIdioma(List<String> idioma) {

           this.idioma = idioma;

       }



       // Getter e setter para downloads

       public int getDownloads() {

           return downloads;

       }



       public void setDownloads(int downloads) {

           this.downloads = downloads;

       }







       @Override

       public String toString() {

           return "Título: " + titulo + "\\n" +

                   "Autor: " + (autores != null && !autores.isEmpty() ? autores.get(0).getNome() : "Desconhecido") + "\\n" +

                   "Idioma: " + (idioma != null && !idioma.isEmpty() ? idioma.get(0) : "N/A") + "\\n" +

                                   "Downloads: " + downloads;

       }

   }





