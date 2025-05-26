package com.devsupeior.dslist.dto;

import com.devsupeior.dslist.entities.Game;
import jakarta.persistence.Column;
import org.springframework.beans.BeanUtils;

public class GameDTO {
    private long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private double score;
    private String imgUrl;
    @Column(columnDefinition = "TEXT")
    private String shortDescription;
    @Column(columnDefinition = "TEXT")
    private String longDescription;

    /**
     * DTO (Data Transfer Object) representa uma versão completa da entidade Game.
     * <p>
     * Contém todos os dados do jogo, usados para exibição detalhada em telas ou APIs,
     * como título, ano, gênero, plataformas, pontuação, imagem e descrições.
     */

    public GameDTO() {
    }

    public GameDTO(Game entity) {

        BeanUtils.copyProperties(entity, this);// Copia automaticamente as propriedades da entidade Game para este DTO,
        // assumindo que os nomes e tipos dos atributos sejam compatíveis
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}

