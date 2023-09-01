package br.com.alura.consumoenergia.adapter.rest.controller.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jmapper.annotations.JMap;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(of = {"descricao"})
public class Parentesco {
    @JMap
    @JsonProperty
    private String descricao;
    public Parentesco(String descricao) {
        this.descricao = descricao;
    }
}
