package com.alura.literatura.pacotes.model;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;



@Entity



public class Autor {



       @Id

       @GeneratedValue(strategy = GenerationType.IDENTITY)

       private Long id;



       private String nome;

       private Integer anoNascimento;

       private Integer falecimento;





       @Override

       public String toString() {

               return "Autor: " + nome +

                                       ", Ano de nascimento: " + anoNascimento +

                                       (falecimento != null ? ", Falecimento: " + falecimento : "");

       }



       // Getters e setters





       public Long getId() {

             return id;

       }



       public void setId(Long id) {

             this.id = id;

       }



       public String getNome() {

             return nome;

       }



       public void setNome(String nome) {

               this.nome = nome;

       }



       public Integer getAnoNascimento() {

               return anoNascimento;



       }



        public void setAnoNascimento(Integer anoNascimento) {

               this.anoNascimento = anoNascimento;

       }



       public Integer getFalecimento() {

               return falecimento;

       }



       public void setFalecimento(Integer anoFalecimento) {

               this.falecimento = anoFalecimento;

       }

}







