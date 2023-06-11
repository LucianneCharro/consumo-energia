package br.com.alura.consumoenergia.controller;

import br.com.alura.consumoenergia.controller.form.EletrodomesticoForm;
import br.com.alura.consumoenergia.dominio.Eletrodomestico;
import br.com.alura.consumoenergia.repository.RepositorioEletrodomestico;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/consumo-energia/eletrodomestico")
@RestController
@AllArgsConstructor
public class CadastroEletrodomesticosController {
    private Validator validator;
    private RepositorioEletrodomestico repositorioEletrodomestico;

    @PostMapping
    public ResponseEntity cadastrarEletrodomestico(@RequestBody EletrodomesticoForm eletrodomesticoRequest) {

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

