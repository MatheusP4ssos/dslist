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
 * Atua como intermediário entre o repositório (persistência) e os controladores (API).
 */

@Service
public class GameService {

    // Injeta automaticamente uma instância do GameRepository
    @Autowired
    private GameRepository gameRepository;

    // Método público que retornar lista de jogos de forma detalhada
    @Transactional(readOnly = true)//Grante integridade com conceitos ACID
    public GameDTO findById(Long id) {
        //busca jogos por meio do ID
        Game result = gameRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Game not found" + id));
        return new GameDTO(result);
    }

    // Método público que retorna uma lista de jogos em forma de DTO resumido
    @Transactional(readOnly = true)//Garante integridade com conceitos ACID
    public List<GameMinDTO> findAll() {
        // Busca todos os jogos do banco de dados
        List<Game> result = gameRepository.findAll();
        // Converte a lista de entidades Game para uma lista de GameMinDTO
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);

        if (result == null || result.isEmpty()) {
            throw new ResourceNotFoundException("No games found for list ID: " + listId);
        }

        return result.stream().map(GameMinDTO::new).toList();
    }
}