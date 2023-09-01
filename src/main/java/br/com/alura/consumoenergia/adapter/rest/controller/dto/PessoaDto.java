package br.com.alura.consumoenergia.adapter.rest.controller.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @Column(name = "CPF")
    @NotBlank(message = "cpf é um campo obrigatório e não pode estar em branco")
    private String cpf;
    @Column(name = "SEXO")
    @NotBlank(message = "sexo é um campo obrigatório e não pode estar em branco")
    private String sexo;
    @ManyToMany
    @JoinTable(name = "TBL_REL_PESSOA_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_PESSOA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO"))
    private List<EnderecoDto> endereco;
    @ManyToMany
    @JoinTable(name = "TBL_REL_PESSOA_ELETRODOMESTICO",
            joinColumns = @JoinColumn(name = "ID_PESSOA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ELETRODOMESTICO"))
    private List<EletrodomesticoDto> eletrodomestico;
    @OneToOne
    @JoinColumn(name = "ID_PARENTESCO")
    private ParentescoDto parentesco;
}
