package br.com.alura.consumoenergia.adapter.rest.controller.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jmapper.annotations.JMap;
import lombok.*;

import java.util.List;

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
    @JsonProperty
    private List<Pessoa> pessoa;
}
