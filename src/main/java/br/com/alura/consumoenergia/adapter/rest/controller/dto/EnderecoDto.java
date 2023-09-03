package br.com.alura.consumoenergia.adapter.rest.controller.dto;

import com.googlecode.jmapper.annotations.JMap;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="TBL_ENDERECO")
public class EnderecoDto {
    @Id
    @Column(name = "ID_ENDERECO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JMap
    @Column(name = "RUA")
    @NotBlank(message = "rua é um campo obrigatório e não pode estar em branco")
    private String rua;
    @JMap
    @Column(name = "NUMERO")
    @NotBlank(message = "numero é um campo obrigatório e não pode estar em branco")
    private Integer numero;
    @JMap
    @Column(name = "BAIRRO")
    @NotBlank(message = "bairro é um campo obrigatório e não pode estar em branco")
    private String bairro;
    @JMap
    @Column(name = "CIDADE")
    @NotBlank(message = "cidade é um campo obrigatório e não pode estar em branco")
    private String cidade;
    @JMap
    @Column(name = "ESTADO")
    @NotBlank(message = "estado é um campo obrigatório e não pode estar em branco")
    private String estado;
    @OneToMany
    @JoinColumn(name = "ID_ELETRODOMESTICO")
    private List<EletrodomesticoDto> eletrodomestico;

}
