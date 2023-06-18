package br.com.alura.consumoenergia.pessoa.controller;

import br.com.alura.consumoenergia.pessoa.respository.RepositorioPessoa;
import br.com.alura.consumoenergia.pessoa.dominio.Pessoa;
import br.com.alura.consumoenergia.pessoa.dto.PessoaDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/consumo-energia/pessoa")
@RestController
@AllArgsConstructor
public class CadastroPessoaController {
    private Validator validator;
    private RepositorioPessoa repositorioPessoas;

    private static final Logger logger = LoggerFactory.getLogger(CadastroPessoaController.class);

    @PostMapping
    public ResponseEntity cadastrarPessoa(@RequestBody PessoaDto pessoaDto,
                                          @RequestHeader(value = "correlationId") String correlationId) {
        logger.info("request: " + Map.of("correlationId", correlationId, "request", pessoaDto));
        Map<Path, String> violacoesToMap = validar(pessoaDto);
        if (!violacoesToMap.isEmpty()) {
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
        Pessoa pessoas = new Pessoa(pessoaDto.getNome(), pessoaDto.getData_nascimento(), pessoaDto.getSexo(), pessoaDto.getGrau_parentesco());
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

