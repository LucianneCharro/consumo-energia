package br.com.alura.consumoenergia.adapter.rest.controller;

import br.com.alura.consumoenergia.adapter.rest.controller.dto.EnderecoDto;
import br.com.alura.consumoenergia.adapter.rest.controller.repository.RepositorioEndereco;
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

@RequestMapping("/consumo-energia/endereco")
@RestController
@AllArgsConstructor
public class CadastroEnderecoController {

    private Validator validator;
    @Autowired
    private RepositorioEndereco repositorioEndereco;
    private static final Logger logger = LoggerFactory.getLogger(CadastroEnderecoController.class);

    @PostMapping
    public ResponseEntity cadastrarEndereco(@RequestBody EnderecoDto endereco,
                                            @RequestHeader(value = "correlationId") String correlationId) {
        logger.info("request: " + Map.of("correlationId", correlationId, "request", endereco));
        Map<Path, String> violacoesToMap = validar(endereco);

        if (!violacoesToMap.isEmpty()) {
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
        var result = repositorioEndereco.findByRua(endereco.getRua());
        if (result.isEmpty()) {
            EnderecoDto saved = repositorioEndereco.save(endereco);
            return ResponseEntity.ok(saved);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity consultarEndereco(@PathVariable Long id) {
        Optional<EnderecoDto> result = repositorioEndereco.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDto> atualizarEndereco(@PathVariable Long id,
                                              @RequestBody EnderecoDto endereco) {
//        var exists = repositorioEndereco.findByRuaAndNumeroIgnoreCaseAndIdNot(endereco.getRua(), endereco.getNumero(), id);
//        if (!exists.isEmpty()) {
//            return ResponseEntity.badRequest().build();
//        }
        if (!repositorioEndereco.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        var updated = repositorioEndereco.save(endereco);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<EnderecoDto> excluirEndereco(@PathVariable Long id) {
        var result = repositorioEndereco.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        repositorioEndereco.deleteById(id);
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

