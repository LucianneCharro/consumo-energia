package br.com.alura.consumoenergia.adapter.rest.controller.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jmapper.annotations.JMap;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(of = {"email", "senha"})
public class Usuario {
    @JMap
    @JsonProperty
    private String email;
    @JMap
    @JsonProperty
    private String senha;
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;

    }
}
