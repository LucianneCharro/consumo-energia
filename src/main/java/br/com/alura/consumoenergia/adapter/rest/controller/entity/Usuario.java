package br.com.alura.consumoenergia.adapter.rest.controller.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jmapper.annotations.JMap;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(of = {"login", "senha", "flag"})
public class Usuario {
    @JMap
    @JsonProperty
    private String login;
    @JMap
    @JsonProperty
    private String senha;
    @JMap
    @JsonProperty
    private String flag;
    public Usuario(String login, String senha, String flag) {
        this.login = login;
        this.senha = senha;
        this.flag = flag;

    }
}
