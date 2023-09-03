package br.com.alura.consumoenergia.adapter.rest.controller.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="TBL_USUARIO")
public class UsuarioDto {
    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "LOGIN")
    @NotBlank(message = "login é um campo obrigatório e não pode estar em branco")
    private String login;
    @Column(name = "SENHA")
    @NotBlank(message = "senha é um campo obrigatório e não pode estar em branco")
    private String senha;
    @Column(name = "FLAG")
    @NotBlank(message = "flag de administrador é um campo obrigatório e não pode estar em branco")
    private String flag;
    @OneToMany
    @JoinColumn(name = "ID_PESSOA")
    private List<PessoaDto> pessoa;
}
