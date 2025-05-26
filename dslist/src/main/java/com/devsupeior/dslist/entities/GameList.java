package com.devsupeior.dslist.entities;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * Entidade que representa uma lista de jogos.
 *
 * Cada objeto GameList corresponde a uma linha na tabela "tb_game_list" do banco de dados.
 * Esta entidade é usada para agrupar jogos em listas específicas, como "Favoritos", "RPGs", "Jogos de 2023", etc.
 */
@Entity
@Table(name= "tb_game_list")
public class GameList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-incrementado pelo banco de dados
    private Long id;

    private String name; // Nome da lista de jogos

    /**
     * Construtor padrão exigido pelo JPA.
     */
    public GameList() {
    }

    /**
     * Construtor com argumentos para facilitar a criação da entidade.
     *
     * @param id   ID da lista.
     * @param name Nome da lista.
     */
    public GameList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Compara dois objetos GameList com base no ID.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GameList gameList)) return false;
        return Objects.equals(id, gameList.id);
    }

    /**
     * Gera o hash com base no ID.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
