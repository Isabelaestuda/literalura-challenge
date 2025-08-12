package com.alura.literatura.pacotes.principal;


import com.alura.literatura.pacotes.client.GutendexClient;

import com.alura.literatura.pacotes.model.Autor;

import com.alura.literatura.pacotes.model.Livro;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.alura.literatura.pacotes.repository.AutorRepository;

import com.alura.literatura.pacotes.dto.LivroDTO;

import com.alura.literatura.pacotes.repository.LivroRepository;

import com.alura.literatura.pacotes.service.EstatisticasService;



import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

import java.util.stream.Collectors;



@SpringBootApplication(scanBasePackages = "com.alura.literatura.pacotes")

@EnableJpaRepositories(basePackages = "com.alura.literatura.pacotes.repository")

@EntityScan(basePackages = "com.alura.literatura.pacotes.model")





public class Principal implements CommandLineRunner{



       @Autowired

       private AutorRepository autorRepository;



   @Autowired

   private LivroRepository livroRepository;





   @Autowired

       private EstatisticasService estatisticasService;



       public static void main(String[] args) {

           SpringApplication.run(Principal.class, args);

       }

   @Override

   public void run(String... args) {



       Scanner scanner = new Scanner(System.in);

       GutendexClient client = new GutendexClient();



       List<LivroDTO> livrosBuscados = new ArrayList<>();



       while (true) {

           System.out.println("\\nMenu de opções:");

           System.out.println("1 - Buscar livro por título");

           System.out.println("2 - Sair");

           System.out.println("3 - Listar livros buscados");

           System.out.println("4 - Listar livros por idioma");

           System.out.println("5 - Listar autores");

           System.out.println("6 - Listar autores vivos em determinado ano");

           System.out.println("7 - Mostrar quantidade de livros por idioma (com 2 ou mais livros)");

           System.out.print("Escolha uma opção: ");



           String linha = scanner.nextLine();

           int opcao;



           try {

               opcao = Integer.parseInt(linha);

           } catch (NumberFormatException e) {

               System.out.println("Por favor, digite um número válido.");

               continue;

           }



           if (opcao == 1) {

               System.out.print("Digite o título: ");

               String titulo = scanner.nextLine();

               var livro = client.buscarPrimeiroLivro(titulo);

               if (livro != null) {

                   livrosBuscados.add(livro);

                   salvarLivroELivroDTO(livro);

                   System.out.println("Livro encontrado:");

                   System.out.println(livro);

               } else {

                   System.out.println("Livro não encontrado.");

               }

           } else if (opcao == 2) {

               System.out.println("Saindo...");
                      break;

           } else if (opcao == 3) {

               if (livrosBuscados.isEmpty()) {

                   System.out.println("Nenhum livro buscado ainda.");

               } else {

                   livrosBuscados.forEach(System.out::println);

               }

           } else if (opcao == 4) {

               System.out.print("Digite o idioma (ex: en, pt, es): ");

               String idioma = scanner.nextLine();



               var filtrados = livrosBuscados.stream()

                                               .filter(l -> l.getIdioma() != null && !l.getIdioma().isEmpty())

                       .filter(l -> l.getIdioma().get(0).equalsIgnoreCase(idioma))

                                               .toList();



               if (filtrados.isEmpty()) {

                   System.out.println("Nenhum livro encontrado com esse idioma.");

               } else {

                   filtrados.forEach(System.out::println);

               }

           } else if (opcao == 5) {

               var autores = livrosBuscados.stream()
                       .filter(l -> l.getAutores() != null && !l.getAutores().isEmpty())

                       .map(l -> l.getAutores().get(0))

                                               .collect(Collectors.toSet());



               if (autores.isEmpty()) {

                   System.out.println("Nenhum autor encontrado.");

               } else {

                   autores.forEach(System.out::println);

               }

           } else if (opcao == 6) {

               System.out.print("Digite o ano: ");

               String entradaAno = scanner.nextLine();

               int ano;

               try {

                   ano = Integer.parseInt(entradaAno);

               } catch (NumberFormatException e) {

                   System.out.println("Ano inválido.");

                   continue;

               }



               var autor = autorRepository.findAll();

               var vivos = autor.stream()

                                               .filter(a -> a.getAnoNascimento() != null)

                                               .filter(a -> {

                           Integer falecimento = a.getFalecimento();

                           return falecimento == null || falecimento >= ano;

                       })

                                               .filter(a -> {

                               Integer nascimento = a.getAnoNascimento();

                           return nascimento != null && nascimento <= ano;

                       })

                                               .toList();



               if (vivos.isEmpty()) {

                   System.out.println("Nenhum autor estava vivo nesse ano.");

               } else {

                   vivos.forEach(System.out::println);

               }

           } else if (opcao == 7) {

               estatisticasService.mostrarQuantidadeLivrosPorIdioma();

           } else {

               System.out.println("Opção inválida. Tente novamente.");

           }

       }

   }



   public void salvarLivroELivroDTO(LivroDTO livroDTO) {

       if (livroDTO.getAutores() == null || livroDTO.getAutores().isEmpty()) {

           System.out.println("Livro sem autor. Ignorado.");

           return;

       }



       Autor autor = autorRepository.findByNome(livroDTO.getAutores().get(0).getNome())

                               .orElseGet(() -> {

                   Autor novoAutor = new Autor();

                   novoAutor.setNome(livroDTO.getAutores().get(0).getNome());

                   novoAutor.setAnoNascimento(livroDTO.getAutores().get(0).getNascimento());

                   novoAutor.setFalecimento(livroDTO.getAutores().get(0).getFalecimento());

                   return autorRepository.save(novoAutor);

               });





       Livro livro = new Livro();

       livro.setTitulo(livroDTO.getTitulo());

       livro.setIdioma(livroDTO.getIdioma() != null && !livroDTO.getIdioma().isEmpty() ? livroDTO.getIdioma().get(0) : null);

       livro.setNumeroDownloads(livroDTO.getDownloads());

       livro.setAutor(autor);

       autorRepository.save(autor);

       }

}

