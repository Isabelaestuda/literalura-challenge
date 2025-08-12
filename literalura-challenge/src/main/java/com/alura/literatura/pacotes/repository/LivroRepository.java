package com.alura.literatura.pacotes.repository;


import com.alura.literatura.pacotes.model.Livro;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;



import java.util.List;



public interface LivroRepository extends JpaRepository<Livro, Long> {



   Long countByIdioma(String idioma);



   @Query("SELECT DISTINCT l.idioma FROM Livro l")

   List<String> findDistinctIdioma();



}



