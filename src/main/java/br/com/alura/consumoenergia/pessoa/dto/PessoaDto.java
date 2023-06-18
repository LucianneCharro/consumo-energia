package br.com.alura.consumoenergia.pessoa.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PessoaDto {
    @NotBlank(message = "nome é um campo obrigatório e não pode estar em branco")
    private String nome;
    @NotBlank(message = "data de nascimento é um campo obrigatório e não pode estar em branco")
    private String data_nascimento;
    @NotBlank(message = "sexo é um campo obrigatório e não pode estar em branco")
    private String sexo;
    @NotBlank(message = "grau de parentesco é um campo obrigatório e não pode estar em branco")
    private String grau_parentesco;
}
