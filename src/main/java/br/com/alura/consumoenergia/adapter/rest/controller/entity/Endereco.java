package br.com.alura.consumoenergia.adapter.rest.controller.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jmapper.annotations.JMap;
import lombok.*;

import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(of = {"endereco", "rua", "numero","bairro","cidade","estado"})
public class Endereco {
    @JMap
    @JsonProperty
    private String rua;
    @JMap
    @JsonProperty
    private Integer numero;
    @JMap
    @JsonProperty
    private String bairro;
    @JMap
    @JsonProperty
    private String cidade;
    @JMap
    @JsonProperty
    private String estado;
    @JsonProperty
    private List<Eletrodomestico> eletrodomestico;
}
