package edu.gustavo.dev_week_publicando_api_restful_na_nuvem.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;

/*
 * Anotar uma classe com @RestControllerAdvice em um projeto Spring Boot tem o efeito de CENTRALIZAR
 * O TRAMANETO DE EXCEÇÕES para todos os controladores REST da aplicação.
 */

/*
 * Na camada de serviço, em implementação, as exceções são lançadas e tratadas e formas personalizadas
 * dentro do Spring boot por esta classe;
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
     * @ExceptionHandler: Define métodos que tratam exceções específicas.
     * Dentro do atributo desta anotação, eu passa a exceção que eu quero trabalhar dentro do método abaixo; 
     * De forma geral, cada método retorna uma resposta HTTP apropriada com uma mensagem de erro.
     */

     
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException() {
        return new ResponseEntity<>("Account already exists", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException()  {
        return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectException() {
        return new ResponseEntity<>("Unexpected server error: 500", HttpStatus.NOT_FOUND);
    }



}
