package com.devsupeior.dslist.projections;

/**
 * Interface de projeção usada para retornar apenas um subconjunto dos dados da entidade Game,
 * usada em consultas personalizadas no banco de dados (JPQL ou SQL nativo).
 *
 * A ideia é projetar apenas os campos realmente necessários, evitando transferir dados desnecessários.
 *
 * Interfaces de projeção funcionam automaticamente com Spring Data JPA se os nomes dos métodos
 * corresponderem exatamente aos aliases dos campos retornados pela consulta.
 */
public interface GameMinProjection {

    Long getId();                    // ID do jogo
    String getTitle();              // Título do jogo
    Integer getGameYear();          // Ano do jogo (nome deve coincidir com o alias na query)
    String getImgUrl();             // URL da imagem do jogo
    String getShortDescription();   // Descrição curta
    Integer getPosition();          // Posição do jogo na lista (relacionado à entidade Belonging)

}
