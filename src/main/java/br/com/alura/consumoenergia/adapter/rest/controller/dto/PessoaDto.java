package br.com.alura.consumoenergia.adapter.rest.controller.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="TBL_PESSOA")
public class PessoaDto {
    @Id
    @Column(name = "ID_PESSOA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOME")
    @NotBlank(message = "nome é um campo obrigatório e não pode estar em branco")
    private String nome;
    @Column(name = "DATA_NASCIMENTO")
    @NotBlank(message = "data de nascimento é um campo obrigatório e não pode estar em branco")
    private String data_nascimento;
    @Column(name = "SEXO")
    @NotBlank(message = "sexo é um campo obrigatório e não pode estar em branco")
    private String sexo;
    @Column(name = "GRAU_PARENTESCO")
    @NotBlank(message = "grau de parentesco é um campo obrigatório e não pode estar em branco")
    private String grau_parentesco;
    @ManyToMany
    private Set<EnderecoDto> enderecos;
    @OneToMany
    private Set<EletrodomesticoDto> eletrodomestico;


}
