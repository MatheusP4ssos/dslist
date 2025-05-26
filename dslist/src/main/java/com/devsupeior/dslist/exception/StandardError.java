package com.devsupeior.dslist.exception;

import java.time.Instant;

/**
 * Classe que representa a estrutura de um erro padrão retornado pela API.
 *
 * <p>Utilizada pelo controlador global de exceções para retornar informações detalhadas
 * sobre falhas em requisições, como erros 404 ou 400.</p>
 */

public class StandardError {
    private Instant timestamp;   // Momento exato em que o erro ocorreu
    private Integer status;     // Código de status HTTP (ex: 404, 400, 500)
    private String error;      // Tipo de erro (ex: "Recurso não encontrado")
    private String message;   // Mensagem mais detalhada sobre o erro
    private String path;     // Caminho da requisição que gerou o erro

    public StandardError() {
    }

    public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Getters e setters

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}