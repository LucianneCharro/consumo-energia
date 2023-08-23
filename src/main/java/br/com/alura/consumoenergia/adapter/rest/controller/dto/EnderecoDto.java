package br.com.alura.consumoenergia.adapter.rest.controller.dto;

import com.googlecode.jmapper.annotations.JMap;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="TBL_ENDERECO")
public class EnderecoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JMap
    @NotBlank(message = "rua é um campo obrigatório e não pode estar em branco")
    private String rua;
    @JMap
    @NotBlank(message = "numero é um campo obrigatório e não pode estar em branco")
    private String numero;
    @JMap
    @NotBlank(message = "bairro é um campo obrigatório e não pode estar em branco")
    private String bairro;
    @JMap
    @NotBlank(message = "cidade é um campo obrigatório e não pode estar em branco")
    private String cidade;
    @JMap
    @NotBlank(message = "estado é um campo obrigatório e não pode estar em branco")
    private String estado;
    @ManyToMany
    private Set<PessoaDto> pessoas;
}
