package br.com.alura.consumoenergia.controller.form;

import com.googlecode.jmapper.annotations.JMap;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoForm {
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
}
