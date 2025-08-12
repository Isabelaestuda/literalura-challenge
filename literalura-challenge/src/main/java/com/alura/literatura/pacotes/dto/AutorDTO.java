package com.alura.literatura.pacotes.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorDTO {

    @JsonAlias("name")
    private String nome;

    @JsonAlias("birth_year")
    private Integer nascimento;

    @JsonAlias("death_year")
    private Integer falecimento;

    @Override
    public String toString() {
        return "Autor: " + getNome() +  // usa getNome() para já vir formatado
                " (Nasc.: " + nascimento +
                ", Falec.: " + (falecimento != null ? falecimento : "vivo") + ")";
    }

    // Aqui a modificação para formatar o nome dinamicamente
    public String getNome() {
        if (nome != null && nome.contains(",")) {
            String[] partes = nome.split(",");
            return partes[1].trim() + " " + partes[0].trim();
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNascimento() {
        return nascimento;
    }

    public void setNascimento(Integer nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getFalecimento() {
        return falecimento;
    }

    public void setFalecimento(Integer falecimento) {
        this.falecimento = falecimento;
    }
}
