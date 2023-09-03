package br.com.alura.consumoenergia.adapter.rest.controller.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jmapper.annotations.JMap;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(of = {"nome", "modelo", "potencia"})
public class Eletrodomestico {
    @JMap
    @JsonProperty
    private String nome;
    @JMap
    @JsonProperty
    private String modelo;
    @JMap
    @JsonProperty
    private String potencia;
}
