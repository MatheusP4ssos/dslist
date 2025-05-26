package com.devsupeior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

/**
 * Classe auxiliar que representa a chave primária composta da entidade Belonging.
 *
 * A anotação @Embeddable indica que esta classe será incorporada em uma entidade (neste caso, Belonging),
 * e não será mapeada como uma tabela separada no banco de dados.
 *
 * Essa chave composta é composta por duas chaves estrangeiras:
 * - game_id (referenciando a entidade Game)
 * - list_id (referenciando a entidade GameList)
 */
@Embeddable
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id") // Define o nome da coluna no banco de dados que referencia Game
    private Game game; // Referência à entidade Game (um jogo)

    @ManyToOne
    @JoinColumn(name = "list_id") // Define o nome da coluna no banco de dados que referencia GameList
    private GameList list; // Referência à entidade GameList (uma lista de jogos)

    /**
     * Construtor padrão exigido pelo JPA.
     */
    public BelongingPK() {
    }

    /**
     * Construtor que permite inicializar a chave composta com os objetos Game e GameList.
     *
     * @param game O jogo associado.
     * @param list A lista associada.
     */
    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    // Getters e setters para os campos da chave composta
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

    /**
     * Sobrescreve o método equals para garantir a correta comparação de objetos da chave composta.
     * Dois objetos são considerados iguais se suas referências a Game e GameList forem iguais.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BelongingPK that)) return false;
        return Objects.equals(game, that.game) && Objects.equals(list, that.list);
    }

    /**
     * Gera o hash code com base nos dois campos da chave composta.
     */
    @Override
    public int hashCode() {
        return Objects.hash(game, list);
    }
}

