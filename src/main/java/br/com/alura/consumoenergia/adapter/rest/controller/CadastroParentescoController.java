package br.com.alura.consumoenergia.adapter.rest.controller;

import br.com.alura.consumoenergia.adapter.rest.controller.dto.ParentescoDto;
import br.com.alura.consumoenergia.adapter.rest.controller.dto.PessoaDto;
import br.com.alura.consumoenergia.adapter.rest.controller.dto.UsuarioDto;
import br.com.alura.consumoenergia.adapter.rest.controller.repository.RepositorioParentesco;
import br.com.alura.consumoenergia.adapter.rest.controller.repository.RepositorioUsuario;
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

@RequestMapping("/consumo-energia/parentesco")
@RestController
@AllArgsConstructor
public class CadastroParentescoController {
    private Validator validator;
    private RepositorioParentesco repositorioparentesco;
    private static final Logger logger = LoggerFactory.getLogger(CadastroParentescoController.class);
    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody ParentescoDto parentesco,
                                           @RequestHeader(value = "correlationId") String correlationId) {
        logger.info("request: " + Map.of("correlationId", correlationId, "request", parentesco));
        Map<Path, String> violacoesToMap = validar(parentesco);

        if (!violacoesToMap.isEmpty()) {
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
        var result = repositorioparentesco.findByDescricao(parentesco.getDescricao());
        if (result.isEmpty()) {
            ParentescoDto saved = repositorioparentesco.save(parentesco);
            return ResponseEntity.ok(saved);
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity consultarPessoa(@PathVariable Long id) {
        Optional<ParentescoDto> result = repositorioparentesco.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<ParentescoDto> atualizarPessoa(@PathVariable Long id,
                                                      @RequestBody ParentescoDto parentesco) {
        var exists = repositorioparentesco.findByDescricao(parentesco.getDescricao());
        if (!exists.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        if (!repositorioparentesco.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        var updated = repositorioparentesco.save(parentesco);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ParentescoDto> excluirPessoa(@PathVariable Long id) {
        var result = repositorioparentesco.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        repositorioparentesco.deleteById(id);
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