package br.com.alura.consumoenergia.adapter.rest.controller;

import br.com.alura.consumoenergia.adapter.rest.controller.dto.EletrodomesticoDto;
import br.com.alura.consumoenergia.adapter.rest.controller.repository.RepositorioEletrodomestico;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/consumo-energia/eletrodomestico")
@RestController
@AllArgsConstructor
public class CadastroEletrodomesticosController {
    private Validator validator;
    @Autowired
    private RepositorioEletrodomestico repositorioEletrodomestico;
    private static final Logger logger = LoggerFactory.getLogger(CadastroEnderecoController.class);

    @PostMapping
    public ResponseEntity cadastrarEletrodomestico(@RequestBody EletrodomesticoDto eletrodomestico,
                                                   @RequestHeader(value = "correlationId") String correlationId) {
        logger.info("request: " + Map.of("correlationId", correlationId, "request", eletrodomestico));
        Map<Path, String> violacoesToMap = validar(eletrodomestico);

        if (!violacoesToMap.isEmpty()) {
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
        var result = repositorioEletrodomestico.findByNome(eletrodomestico.getNome());
        if (result.isEmpty()) {
            EletrodomesticoDto saved = repositorioEletrodomestico.save(eletrodomestico);
            return ResponseEntity.ok(saved);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity consultarEletrodomestico(@PathVariable Long id) {
        Optional<EletrodomesticoDto> result = repositorioEletrodomestico.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EletrodomesticoDto> atualizarEletrodomestico(@PathVariable Long id,
                                                                       @RequestBody EletrodomesticoDto eletrodomestico) {
        Optional<EletrodomesticoDto> exists = repositorioEletrodomestico.findById(id);
        if (exists.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var updated = repositorioEletrodomestico.save(eletrodomestico);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EletrodomesticoDto> excluirEletrodomestico(@PathVariable Long id) {
        var result = repositorioEletrodomestico.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        repositorioEletrodomestico.deleteById(id);
        return ResponseEntity.ok().build();
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

