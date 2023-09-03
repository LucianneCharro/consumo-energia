package br.com.alura.consumoenergia.adapter.rest.controller.dto;

import br.com.alura.consumoenergia.adapter.rest.controller.enuns.TipoParentesco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.Date;
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
    @Column(name = "PARENTESCO")
    @Enumerated(EnumType.STRING)
    private TipoParentesco grau_parentesco;
    @OneToMany
    @JoinColumn(name = "ID_ENDERECO")
    private List<EnderecoDto> endereco;
}
