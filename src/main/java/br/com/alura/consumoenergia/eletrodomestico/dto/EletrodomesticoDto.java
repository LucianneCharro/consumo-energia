package br.com.alura.consumoenergia.eletrodomestico.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EletrodomesticoDto {
    @NotBlank(message = "nome é um campo obrigatório e não pode estar em branco")
    private String nome;
    @NotBlank(message = "modelo é um campo obrigatório e não pode estar em branco")
    private String modelo;
    @NotBlank(message = "potencia é um campo obrigatório e não pode estar em branco")
    private String potencia;
}
