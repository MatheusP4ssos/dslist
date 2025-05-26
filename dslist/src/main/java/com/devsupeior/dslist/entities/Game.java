package com.devsupeior.dslist.entities;

import java.util.Objects;
import jakarta.persistence.*;

/**
 * Entidade que representa um jogo no sistema.
 *
 * Esta classe é mapeada para a tabela "tb_game" no banco de dados.
 * Contém informações como título, ano, gênero, plataformas, pontuação e descrições.
 */
@Entity
@Table(name = "tb_game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID gerado automaticamente pelo banco (auto-incremento)
    private long id;

    private String title;

    // Mapeia o campo "year" da tabela com nome personalizado (atenção ao espaço extra no nome)
    @Column(name = "game_year ")
    private Integer year;

    private String genre;
    private String platforms;
    private double score;
    private String imgUrl;

    // Armazena grandes textos no banco como tipo TEXT (ao invés do padrão VARCHAR)
    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String longDescription;

    /**
     * Construtor padrão exigido pelo JPA.
     */
    public Game() {
    }

    /**
     * Construtor que inicializa alguns dos principais atributos.
     * Os campos shortDescription e longDescription não são passados como parâmetro aqui.
     */
    public Game(Long id, String title, Integer year, String genre, String platforms, double score, String imgUrl) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        // shortDescription e longDescription ficaram nulos por padrão
    }

    // Getters e setters para todos os campos

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

    /**
     * Define que dois objetos Game são iguais se tiverem o mesmo ID.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Game game)) return false;
        return id == game.id;
    }

    /**
     * Gera o hash com base no ID (importante para coleções como Set).
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
