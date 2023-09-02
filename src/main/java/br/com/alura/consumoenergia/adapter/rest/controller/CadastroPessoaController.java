package br.com.alura.consumoenergia.adapter.rest.controller;

import br.com.alura.consumoenergia.adapter.rest.controller.dto.PessoaDto;
import br.com.alura.consumoenergia.adapter.rest.controller.repository.RepositorioPessoa;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/consumo-energia/pessoa")
@RestController
@AllArgsConstructor
public class CadastroPessoaController {
    private Validator validator;
    private RepositorioPessoa repositorioPessoa;

    private static final Logger logger = LoggerFactory.getLogger(CadastroPessoaController.class);

    @PostMapping
    public ResponseEntity cadastrarPessoa(@RequestBody PessoaDto pessoa,
                                          @RequestHeader(value = "correlationId") String correlationId) {
        logger.info("request: " + Map.of("correlationId", correlationId, "request", pessoa));
        Map<Path, String> violacoesToMap = validar(pessoa);
        if (!violacoesToMap.isEmpty()) {
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
        var result = repositorioPessoa.findByCpf(pessoa.getCpf());
        if (result.isEmpty()) {
            PessoaDto saved = repositorioPessoa.save(pessoa);
            return ResponseEntity.ok(saved);
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity consultarPessoa(@PathVariable Long id) {
        Optional<PessoaDto> result = repositorioPessoa.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> atualizarPessoa(@PathVariable Long id,
                                                                       @RequestBody PessoaDto pessoa) {
        var exists = repositorioPessoa.findByCpfAndNomeIgnoreCaseAndIdNot(pessoa.getCpf(), pessoa.getNome(), id);
        if (!exists.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        if (!repositorioPessoa.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        var updated = repositorioPessoa.save(pessoa);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<PessoaDto> excluirPessoa(@PathVariable Long id) {
        var result = repositorioPessoa.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        repositorioPessoa.deleteById(id);
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

