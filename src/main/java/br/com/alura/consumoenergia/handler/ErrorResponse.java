package br.com.alura.consumoenergia.handler;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@Builder
public class ErrorResponse {

    private Instant timestamp;
    private Integer code;
    private HttpStatus httpStatus;
    private String mensagem;
    private String path;
}
