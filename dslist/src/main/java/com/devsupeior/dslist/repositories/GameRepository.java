package com.devsupeior.dslist.repositories;

import com.devsupeior.dslist.entities.Game;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface responsável por acessar os dados da entidade Game.
 * <p>
 * Esta interface herda os métodos padrão do JpaRepository,
 * como salvar, buscar, deletar e atualizar registros no banco de dados.
 */

public interface GameRepository extends JpaRepository<Game, Long> {
    // Repositório JPA para entidade Game com ID do tipo Long

}
