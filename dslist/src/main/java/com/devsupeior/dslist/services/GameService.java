package com.devsupeior.dslist.services;

import com.devsupeior.dslist.dto.GameDTO;
import com.devsupeior.dslist.dto.GameMinDTO;
import com.devsupeior.dslist.entities.Game;
import com.devsupeior.dslist.exception.ResourceNotFoundException;
import com.devsupeior.dslist.projections.GameMinProjection;
import com.devsupeior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Serviço responsável por operações relacionadas à entidade Game.
 * Atua como intermediário entre o repositório (acesso ao banco) e os controladores (API REST).
 */
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository; // Repositório que fornece acesso à tabela tb_game

    /**
     * Busca um jogo pelo seu ID e o converte para DTO detalhado.
     * Lança exceção personalizada caso o jogo não seja encontrado.
     *
     * @param id ID do jogo a ser buscado
     * @return GameDTO contendo todos os dados do jogo
     */
    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found: " + id));

        return new GameDTO(result);
    }

    /**
     * Retorna todos os jogos cadastrados, em formato resumido (GameMinDTO).
     *
     * @return Lista de jogos resumidos
     */
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    /**
     * Retorna os jogos que pertencem a uma determinada lista.
     * Usa projeção para buscar apenas os campos necessários, o que melhora a performance.
     *
     * @param listId ID da lista desejada
     * @return Lista de jogos com dados mínimos (GameMinDTO)
     * @throws ResourceNotFoundException caso a lista esteja vazia ou não exista
     */
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);

        if (result == null || result.isEmpty()) {
            throw new ResourceNotFoundException("No games found for list ID: " + listId);
        }

        return result.stream().map(GameMinDTO::new).toList();
    }
}
