package com.devsupeior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

/**
 * Entidade que representa o relacionamento entre um jogo (Game) e uma lista de jogos (GameList).
 *
 * A tabela "tb_belonging" faz o mapeamento entre jogos e listas, indicando a qual lista
 * um jogo pertence e sua posição dentro dessa lista.
 *
 * Utiliza uma chave composta (@EmbeddedId) para identificar unicamente a associação
 * entre um jogo e uma lista.
 */
@Entity
@Table(name = "tb_belonging")
public class Belonging {

    // Chave composta contendo referências à entidade Game e à entidade GameList
    @EmbeddedId
    private BelongingPK id = new BelongingPK();

    // Posição do jogo dentro da lista
    private Integer position;

    /**
     * Construtor padrão exigido pelo JPA.
     */
    public Belonging() {
    }

    /**
     * Construtor que permite inicializar um relacionamento entre um jogo e uma lista com a posição.
     *
     * @param game     O jogo a ser associado.
     * @param list     A lista à qual o jogo será associado.
     * @param position A posição do jogo dentro da lista.
     */
    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }

    // Getter e Setter para o ID (chave composta)
    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }

    // Getter e Setter para a posição
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * Sobrescreve o método equals para comparar corretamente objetos Belonging,
     * com base no valor da chave composta (id).
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Belonging belonging)) return false;
        return Objects.equals(id, belonging.id);
    }

    /**
     * Gera o hash code com base na chave composta.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
