package br.com.alura.consumoenergia.adapter.rest.controller;

import br.com.alura.consumoenergia.adapter.rest.controller.dto.UsuarioDto;
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

@RequestMapping("/consumo-energia/usuario")
@RestController
@AllArgsConstructor
public class CadastroUsuarioController {
    private Validator validator;
    private RepositorioUsuario repositoriousuario;
    private static final Logger logger = LoggerFactory.getLogger(CadastroUsuarioController.class);
    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody UsuarioDto usuario,
                                           @RequestHeader(value = "correlationId") String correlationId) {
        logger.info("request: " + Map.of("correlationId", correlationId, "request", usuario));
        Map<Path, String> violacoesToMap = validar(usuario);
        if (!violacoesToMap.isEmpty()) {
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
        var result = repositoriousuario.findByLogin(usuario.getLogin());
        if (result.isEmpty()) {
            UsuarioDto saved = repositoriousuario.save(usuario);
            return ResponseEntity.ok(saved);
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity consultarUsuario(@PathVariable Long id) {
        Optional<UsuarioDto> result = repositoriousuario.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> atualizarUsuario(@PathVariable Long id,
                                                      @RequestBody UsuarioDto usuario) {
        var exists = repositoriousuario.findByLogin(usuario.getLogin());
        if (!exists.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        if (!repositoriousuario.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        var updated = repositoriousuario.save(usuario);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDto> excluirUsuario(@PathVariable Long id) {
        var result = repositoriousuario.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        repositoriousuario.deleteById(id);
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