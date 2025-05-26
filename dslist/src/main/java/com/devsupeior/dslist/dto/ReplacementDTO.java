package com.devsupeior.dslist.dto;

/**
 * DTO (Data Transfer Object) utilizado para transferir os dados necessários
 * para realizar a movimentação de um item (jogo) dentro de uma lista.
 *
 * Contém os índices de origem e destino da posição onde o item será movido.
 *
 * Essa classe é normalmente utilizada no corpo da requisição (JSON) enviada ao endpoint
 * que manipula a reordenação de jogos em uma lista específica.
 */
public class ReplacementDTO {

    // Índice original do item na lista
    private Integer sourceIndex;

    // Novo índice para onde o item será movido
    private Integer destinationIndex;

    /**
     * Retorna o índice de origem.
     *
     * @return índice atual do item na lista
     */
    public Integer getSourceIndex() {
        return sourceIndex;
    }

    /**
     * Define o índice de origem.
     *
     * @param sourceIndex índice atual do item na lista
     */
    public void setSourceIndex(Integer sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    /**
     * Retorna o índice de destino.
     *
     * @return novo índice do item na lista
     */
    public Integer getDestinationIndex() {
        return destinationIndex;
    }

    /**
     * Define o índice de destino.
     *
     * @param destinationIndex novo índice do item na lista
     */
    public void setDestinationIndex(Integer destinationIndex) {
        this.destinationIndex = destinationIndex;
    }
}
