package br.com.alura.consumoenergia.adapter.rest.controller.entity;

import br.com.alura.consumoenergia.adapter.rest.controller.enuns.TipoParentesco;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jmapper.annotations.JMap;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(of = {"nome", "data_nascimento", "cpf", "sexo", "grau_parentesco"})
public class Pessoa {
    @JMap
    @JsonProperty
    private String nome;
    @JMap
    @JsonProperty
    private Date data_nascimento;
    @JMap
    @JsonProperty
    private String cpf;
    @JMap
    @JsonProperty
    private String sexo;
    @JMap
    @JsonProperty
    private TipoParentesco grau_parentesco;
    @JsonProperty
    private List<Endereco> endereco;

}
