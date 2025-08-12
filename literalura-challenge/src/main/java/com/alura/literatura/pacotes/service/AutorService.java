/*package org.example.service;


import org.example.model.Autor;
import org.example.repository.AutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor salvarAutor(Autor autor) {
        // Evita duplicados (poderia melhorar com equals/hashCode, ou busca)
        return autorRepository.save(autor);
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    // Passo 10 - autores vivos em um determinado ano
    public List<Autor> listarAutoresVivosEmAno(int ano) {
        return autorRepository.findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanOrAnoFalecimentoIsNull(ano, ano);
    }
}
*/