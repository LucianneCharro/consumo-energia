package br.com.alura.consumoenergia.adapter.rest.controller;

import br.com.alura.consumoenergia.adapter.rest.controller.repository.RepositorioPessoa;
import br.com.alura.consumoenergia.adapter.rest.controller.dominio.Pessoa;
import br.com.alura.consumoenergia.adapter.rest.controller.dto.PessoaDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/consumo-energia/v1")
@RestController
@AllArgsConstructor
public class CadastroPessoaController {
    private Validator validator;
    private RepositorioPessoa repositorioPessoas;

    private static final Logger logger = LoggerFactory.getLogger(CadastroPessoaController.class);

    @PostMapping("/pessoa")
    public ResponseEntity cadastrarPessoa(@RequestBody PessoaDto pessoaDto,
                                          @RequestHeader(value = "correlationId") String correlationId) {
        logger.info("request: " + Map.of("correlationId", correlationId, "request", pessoaDto));
        Map<Path, String> violacoesToMap = validar(pessoaDto);
        if (!violacoesToMap.isEmpty()) {
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
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

