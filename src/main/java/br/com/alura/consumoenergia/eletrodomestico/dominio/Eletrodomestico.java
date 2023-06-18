package br.com.alura.consumoenergia.eletrodomestico.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jmapper.annotations.JMap;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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

    public Eletrodomestico(String nome, String modelo, String potencia) {
        this.nome = nome;
        this.modelo = modelo;
        this.potencia = potencia;
    }
}
