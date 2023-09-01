package br.com.alura.consumoenergia.adapter.rest.controller.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TBL_PARENTESCO")
public class ParentescoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PARENTESCO")
    private Long id;
    @Column(name = "DESCRICAO")
    @NotBlank(message = "Descricao é um campo obrigatório e não pode estar em branco")
    private String descricao;
}
