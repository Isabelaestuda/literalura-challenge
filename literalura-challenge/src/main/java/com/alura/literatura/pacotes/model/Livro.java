package com.alura.literatura.pacotes.model;




import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.CascadeType;



       @Entity

       public class Livro {

               @Id

               @GeneratedValue(strategy = GenerationType.IDENTITY)

               private Long id;

               private String titulo;



       private Integer numeroDownloads;

       private String idioma;



     //@ManyToOne: muitos livros podem ter o mesmo autor, mas cada livro tem apenas um autor.

     //(cascade = CascadeType.PERSIST): o autor será automaticamente salvo junto com o livro, mesmo que ele ainda não esteja no banco



       @ManyToOne (cascade = CascadeType.PERSIST)

       private Autor autor;



       // Getters e setters



       public Long getId() {

               return id;

       }



       public String getTitulo() {

               return titulo;

       }



       public void setTitulo(String titulo) {

               this.titulo = titulo;

       }



       public Integer getnumeroDownloads() {

               return numeroDownloads;

       }



       public void setNumeroDownloads(Integer numeroDownloads) {

               this.numeroDownloads = numeroDownloads;

       }



       public String getIdioma() {

               return idioma;

       }



       public void setIdioma(String Idioma) {

               this.idioma = Idioma;

       }



       public Autor getAutor() {

               return autor;

       }



       public void setAutor(Autor autor) {

               this.autor = autor;

       }

}







