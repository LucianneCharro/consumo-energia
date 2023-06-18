package br.com.alura.consumoenergia.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class RestControllerHandler {
    private static final Logger logger = LoggerFactory.getLogger(RestControllerHandler.class);

    private static final String CORRELATION_NAO_INFORMADO = "Informar 'correlationID' no Header.";
    private static final String VALIDACAO_JSON = "Json não pode conter atribulos nulo, vazio ou em branco.";
    private static final String CONTENT_TYPE_ERRO = "Content-Type 'application/octet-stream' não é suportado.";

    @ExceptionHandler(MissingRequestHeaderException.class)
    private ResponseEntity<ErrorResponse> handlerMissingRequestHeader(HttpServletRequest httpServlet) {

        val httpStatus = HttpStatus.BAD_REQUEST;

        val code = HttpStatus.BAD_REQUEST.value();

        val mensagemErro = CORRELATION_NAO_INFORMADO;

        val path = httpServlet.getRequestURI();

        logger.error("Error: " + mensagemErro);

        return montarRetorno(httpStatus, code, path, mensagemErro);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    private ResponseEntity<ErrorResponse> handlerHttpUnsupoportedMediaType(Exception ex, HttpServletRequest httpServlet) {

        val httpStatus = HttpStatus.UNSUPPORTED_MEDIA_TYPE;

        val code = HttpStatus.UNSUPPORTED_MEDIA_TYPE.value();

        val mensagemErro = CONTENT_TYPE_ERRO;

        val path = httpServlet.getRequestURI();

        logger.error("Error: " + mensagemErro);

        return montarRetorno(httpStatus, code, path, mensagemErro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ErrorResponse> handlerMethodArgumentNotValidException(Exception ex, HttpServletRequest httpServlet) {

        val httpStatus = HttpStatus.BAD_REQUEST;

        val code = HttpStatus.BAD_REQUEST.value();

        val mensagemErro = VALIDACAO_JSON;

        val path = httpServlet.getRequestURI();

        logger.error("Error: " + mensagemErro);

        return montarRetorno(httpStatus, code, path, mensagemErro);
    }

    private ResponseEntity<ErrorResponse> montarRetorno(HttpStatus httpStatus, int code, String path, String msg) {
        return new ResponseEntity<>(new ErrorResponse(Instant.now(), code, httpStatus, msg, path), httpStatus);
    }

}