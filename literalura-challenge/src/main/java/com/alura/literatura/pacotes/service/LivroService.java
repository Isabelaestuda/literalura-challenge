/*package org.example.service;

import org.example.client.GutendexClient;
import org.example.dto.AutorDTO;
import org.example.dto.LivroDTO;
import org.example.model.Autor;
import org.example.model.Livro;
import org.example.repository.LivroRepository;
import org.example.service.AutorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorService autorService;
    private final GutendexClient gutendexClient;

    public LivroService(LivroRepository livroRepository, AutorService autorService, GutendexClient gutendexClient) {
        this.livroRepository = livroRepository;
        this.autorService = autorService;
        this.gutendexClient = gutendexClient;
    }

    // Passo 6 e 7: busca livro na API e salva no banco junto com autor
    public Livro buscarESalvarLivroPorTitulo(String titulo) throws Exception {
        GutendexClient.LivroDTOWrapper dtoWrapper = gutendexClient.buscarLivroPorTitulo(titulo);
        if (dtoWrapper.getResults() == null || dtoWrapper.getResults().isEmpty()) {
            return null;
        }

        LivroDTO livroDTO = dtoWrapper.getResults().get(0); // só o primeiro livro (Passo 6)

        // Só o primeiro autor (Passo 7)
        AutorDTO autorDTO = (livroDTO.getAutores() != null && !livroDTO.getAutores().isEmpty()) ? livroDTO.getAutores().get(0) : null;
        Autor autor = null;
        if (autorDTO != null) {
            autor = new Autor(autorDTO.getNome(), autorDTO.getAnoNascimento(), autorDTO.getAnoFalecimento());
            autor = autorService.salvarAutor(autor);
        }

        Livro livro = new Livro();
        livro.setTitulo(livroDTO.getTitulo());
        livro.setAutor(autor);

        // Pega só o primeiro idioma (Passo 6)
        if (livroDTO.getIdiomas() != null && !livroDTO.getIdiomas().isEmpty()) {
            livro.setIdioma(livroDTO.getIdiomas().get(0));
        }

        livro.setNumeroDownloads(livroDTO.getNumeroDownloads());

        return livroRepository.save(livro);
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public List<Livro> listarPorIdioma(String idioma) {
        return livroRepository.findByIdiomaIgnoreCase(idioma);
    }

    public long contarLivrosPorIdioma(String idioma) {
        return livroRepository.countByIdiomaIgnoreCase(idioma);
    }
}
*/