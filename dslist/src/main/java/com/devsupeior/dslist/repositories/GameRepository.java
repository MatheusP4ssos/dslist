package com.devsupeior.dslist.repositories;

import com.devsupeior.dslist.entities.Game;

import com.devsupeior.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Interface responsável por acessar os dados da entidade Game.
 * <p>
 * Esta interface herda os métodos padrão do JpaRepository,
 * como salvar, buscar, deletar e atualizar registros no banco de dados.
 */

public interface GameRepository extends JpaRepository<Game, Long> {
    // Repositório JPA para entidade Game com ID do tipo Long

    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
    List<GameMinProjection> searchByList(Long listId);
}
