package br.com.alura.consumoenergia.controller;

import br.com.alura.consumoenergia.controller.form.EnderecoForm;
import br.com.alura.consumoenergia.dominio.Endereco;
import br.com.alura.consumoenergia.repository.RepositorioEndereco;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/consumo-energia/endereco")
@RestController
@AllArgsConstructor
public class CadastroEnderecoController {

    private Validator validator;
    private RepositorioEndereco repositorioEndereco;

    @PostMapping
        public ResponseEntity cadastrarEndereco(@RequestBody EnderecoForm enderecoRequest) {

        Map<Path, String> violacoesToMap = validar(enderecoRequest);

        if(!violacoesToMap.isEmpty()){
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
        Endereco endereco = new Endereco(enderecoRequest.getRua(), enderecoRequest.getNumero(), enderecoRequest.getBairro(), enderecoRequest.getCidade(), enderecoRequest.getEstado());
        repositorioEndereco.salvar(endereco);
        return ResponseEntity.ok("Endereço cadastrado com sucesso");
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

