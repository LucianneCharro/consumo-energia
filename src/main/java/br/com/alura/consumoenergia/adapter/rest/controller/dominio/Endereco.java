package br.com.alura.consumoenergia.adapter.rest.controller.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jmapper.annotations.JMap;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@EqualsAndHashCode(of = {"endereco", "rua", "numero","bairro","cidade","estado"})
public class Endereco {
    @JMap
    @JsonProperty
    private String rua;
    @JMap
    @JsonProperty
    private String numero;
    @JMap
    @JsonProperty
    private String bairro;
    @JMap
    @JsonProperty
    private String cidade;
    @JMap
    @JsonProperty
    private String estado;

    public Endereco(String rua, String numero, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
}
