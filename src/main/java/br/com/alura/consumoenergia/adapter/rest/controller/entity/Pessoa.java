package br.com.alura.consumoenergia.adapter.rest.controller.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jmapper.annotations.JMap;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(of = {"nome", "data_nascimento", "cpf", "sexo", "grau_parentesco"})
public class Pessoa {
    @JMap
    @JsonProperty
    private String nome;
    @JMap
    @JsonProperty
    private String data_nascimento;
    @JMap
    @JsonProperty
    private String cpf;
    @JMap
    @JsonProperty
    private String sexo;
    @JMap
    @JsonProperty
    private String grau_parentesco;
    public Pessoa(String nome, String data_nascimento, String cpf, String sexo, String grau_parentesco) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.sexo = sexo;
        this.grau_parentesco = grau_parentesco;
    }
}
