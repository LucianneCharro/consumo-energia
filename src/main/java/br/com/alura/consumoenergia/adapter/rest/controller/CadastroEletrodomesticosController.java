package br.com.alura.consumoenergia.adapter.rest.controller;

import br.com.alura.consumoenergia.adapter.rest.controller.dominio.Eletrodomestico;
import br.com.alura.consumoenergia.adapter.rest.controller.dto.EletrodomesticoDto;
import br.com.alura.consumoenergia.adapter.rest.controller.repository.RepositorioEletrodomestico;
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
public class CadastroEletrodomesticosController {
    private Validator validator;
    private RepositorioEletrodomestico repositorioEletrodomestico;
    private static final Logger logger = LoggerFactory.getLogger(CadastroEnderecoController.class);

    @PostMapping("/eletrodomestico")
    public ResponseEntity cadastrarEletrodomestico(@RequestBody EletrodomesticoDto eletrodomesticoRequest,
                                                   @RequestHeader(value = "correlationId") String correlationId) {
        logger.info("request: " + Map.of("correlationId", correlationId, "request", eletrodomesticoRequest));
        Map<Path, String> violacoesToMap = validar(eletrodomesticoRequest);

        if (!violacoesToMap.isEmpty()) {
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
        return ResponseEntity.ok("Eletrodomestico cadastrado com sucesso");
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

