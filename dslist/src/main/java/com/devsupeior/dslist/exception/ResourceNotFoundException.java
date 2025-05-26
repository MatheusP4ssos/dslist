package com.devsupeior.dslist.exception;

/**
 * Exceção personalizada que representa a ausência de um recurso no sistema.
 *
 * <p>Lançada quando uma entidade (como um jogo) não é encontrada no banco de dados.
 * É uma subclasse de {@link RuntimeException}, o que permite ser usada em métodos sem
 * a obrigatoriedade de tratamento com try/catch.</p>
 */

public class ResourceNotFoundException extends RuntimeException {
    /**
     * Exceção personalizada que representa a ausência de um recurso no sistema.
     *
     * <p>Lançada quando uma entidade (como um jogo) não é encontrada no banco de dados.
     * É uma subclasse de {@link RuntimeException}, o que permite ser usada em métodos sem
     * a obrigatoriedade de tratamento com try/catch.</p>
     */
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
