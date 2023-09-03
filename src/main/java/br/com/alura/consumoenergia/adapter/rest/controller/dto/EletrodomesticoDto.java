package br.com.alura.consumoenergia.adapter.rest.controller.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TBL_ELETRODOMESTICO")
public class EletrodomesticoDto {
    @Id
    @Column(name = "ID_ELETRODOMESTICO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOME")
    @NotBlank(message = "nome é um campo obrigatório e não pode estar em branco")
    private String nome;
    @Column(name = "MODELO")
    @NotBlank(message = "modelo é um campo obrigatório e não pode estar em branco")
    private Integer modelo;
    @Column(name = "POTENCIA")
    @NotBlank(message = "potencia é um campo obrigatório e não pode estar em branco")
    private Double potencia;
}
