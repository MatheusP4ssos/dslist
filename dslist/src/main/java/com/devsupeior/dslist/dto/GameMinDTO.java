package com.devsupeior.dslist.dto;

import com.devsupeior.dslist.entities.Game;
import com.devsupeior.dslist.projections.GameMinProjection;
import jakarta.persistence.Column;

public class GameMinDTO {
    private long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    /**
     * DTO (Data Transfer Object) que representa uma versão resumida da entidade Game.
     * <p>
     * Contém os dados básicos do jogo usados para exibição simplificada,
     * como ID, título, ano, URL da imagem e descrição curta.
     */

    public GameMinDTO() {
    }

    // Construtor da classe GameMinDTO que recebe uma entidade Game como parâmetro
    public GameMinDTO(Game entity) {
        // Atribui o ID da entidade Game ao DTO
        id = entity.getId();
        // Atribui o título do jogo ao DTO
        title = entity.getTitle();
        // Atribui o ano de lançamento do jogo ao DTO
        year = entity.getYear();
        // Atribui a URL da imagem do jogo ao DTO
        imgUrl = entity.getImgUrl();
        // Atribui a descrição curta do jogo ao DTO
        shortDescription = entity.getShortDescription();
    }

    public GameMinDTO(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getGameYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

}
