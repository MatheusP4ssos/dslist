package com.devsupeior.dslist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

/**
 * Classe responsável por capturar exceções lançadas pelos controladores da aplicação
 * e retornar respostas HTTP padronizadas com detalhes do erro.
 *
 * <p>Utiliza a anotação {@code @RestControllerAdvice}, que permite interceptar exceções
 * lançadas nos controllers e tratá-las globalmente.</p>
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Manipula exceções do tipo {@link ResourceNotFoundException}, que indicam
     * que um recurso solicitado não foi encontrado.
     *
     * @param e A exceção capturada
     * @return Um ResponseEntity contendo o corpo de erro com status 404
     */

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e) {
        // Cria uma resposta de erro padrão com informações sobre a exceção
        StandardError err = new StandardError(
                Instant.now(),// Momento do erro
                HttpStatus.NOT_FOUND.value(),// Código de status HTTP 404
                "Jogo ou lista de jogos não encontrada",// Descrição do erro
                e.getMessage(),// Mensagem detalhada da exceção
                "/games" // Caminho da requisição (pode ser extraído dinamicamente)
        );
        // Retorna a resposta com status 404 (NOT FOUND)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
