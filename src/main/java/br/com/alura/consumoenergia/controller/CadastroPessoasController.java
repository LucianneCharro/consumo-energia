package br.com.alura.consumoenergia.controller;

import br.com.alura.consumoenergia.controller.form.PessoasForm;
import br.com.alura.consumoenergia.dominio.Pessoas;
import br.com.alura.consumoenergia.repository.RepositorioPessoas;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/consumo-energia/pessoa")
@RestController
@AllArgsConstructor
public class CadastroPessoasController {
    private Validator validator;
    private RepositorioPessoas repositorioPessoas;
    @PostMapping
    public ResponseEntity cadastrarPessoa(@RequestBody PessoasForm pessoasRequest) {

        Map<Path, String> violacoesToMap = validar(pessoasRequest);

        if(!violacoesToMap.isEmpty()){
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
        Pessoas pessoas = new Pessoas(pessoasRequest.getNome(), pessoasRequest.getData_nascimento(), pessoasRequest.getSexo(), pessoasRequest.getGrau_parentesco());
        repositorioPessoas.salvar(pessoas);
        return ResponseEntity.ok("Pessoa cadastrada com sucesso");
    }
    private <T> Map<Path, String> validar(T form) {
        Set<ConstraintViolation<T>> violacoes =
                validator.validate(form);

        Map<Path, String> violacoesToMap = violacoes.stream()
                .collect(Collectors.toMap(
                        violacao -> violacao.getPropertyPath(), violacao -> violacao.getMessage()));
        return violacoesToMap;
    }
}

