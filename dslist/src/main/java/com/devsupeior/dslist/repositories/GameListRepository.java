package com.devsupeior.dslist.repositories;

import com.devsupeior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Interface responsável por acessar os dados da entidade Game.
 * <p>
 * Esta interface herda os métodos padrão do JpaRepository,
 * como salvar, buscar, deletar e atualizar registros no banco de dados.
 */

public interface GameListRepository extends JpaRepository<GameList, Long> {
    // Repositório JPA para entidade Game com ID do tipo Long

    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
