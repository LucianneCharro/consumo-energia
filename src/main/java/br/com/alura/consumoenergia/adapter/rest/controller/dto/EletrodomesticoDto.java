package br.com.alura.consumoenergia.adapter.rest.controller.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="TBL_ELETRODOMESTICO")
public class EletrodomesticoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "nome é um campo obrigatório e não pode estar em branco")
    private String nome;
    @NotBlank(message = "modelo é um campo obrigatório e não pode estar em branco")
    private String modelo;
    @NotBlank(message = "potencia é um campo obrigatório e não pode estar em branco")
    private String potencia;
}
