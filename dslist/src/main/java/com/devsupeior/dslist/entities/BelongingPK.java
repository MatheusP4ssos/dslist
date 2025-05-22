package com.devsupeior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

/**
 * Classe auxiliar que representa a chave primária composta da entidade Belonging.
 * <p>
 * A anotação @Embeddable indica que esta classe será incorporada em outra entidade (Belonging).
 * Ela une as entidades Game e GameList, formando a chave composta.
 */

@Embeddable
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;// Referência à entidade Game

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list; // Referência à entidade GameList


    public BelongingPK() {
    }

    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BelongingPK that)) return false;
        return Objects.equals(game, that.game) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, list);
    }
}

