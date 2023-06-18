package br.com.alura.consumoenergia.eletrodomestico.controller;

import br.com.alura.consumoenergia.eletrodomestico.dominio.Eletrodomestico;
import br.com.alura.consumoenergia.eletrodomestico.dto.EletrodomesticoDto;
import br.com.alura.consumoenergia.eletrodomestico.repository.RepositorioEletrodomestico;
import br.com.alura.consumoenergia.endereco.controller.CadastroEnderecoController;
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

@RequestMapping("/consumo-energia/eletrodomestico")
@RestController
@AllArgsConstructor
public class CadastroEletrodomesticosController {
    private Validator validator;
    private RepositorioEletrodomestico repositorioEletrodomestico;
    private static final Logger logger = LoggerFactory.getLogger(CadastroEnderecoController.class);

    @PostMapping
    public ResponseEntity cadastrarEletrodomestico(@RequestBody EletrodomesticoDto eletrodomesticoRequest,
                                                   @RequestHeader(value = "correlationId") String correlationId){
        logger.info("request: " + Map.of("correlationId", correlationId, "request", eletrodomesticoRequest));
        Map<Path, String> violacoesToMap = validar(eletrodomesticoRequest);

        if(!violacoesToMap.isEmpty()){
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
        Eletrodomestico eletrodomestico = new Eletrodomestico(eletrodomesticoRequest.getNome(), eletrodomesticoRequest.getModelo(), eletrodomesticoRequest.getPotencia());
        repositorioEletrodomestico.salvar(eletrodomestico);
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

