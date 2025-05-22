package com.devsupeior.dslist.services;

import com.devsupeior.dslist.dto.GameMinDTO;
import com.devsupeior.dslist.entities.Game;

import com.devsupeior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * A classe GameService faz parte da camada de serviço da aplicação Spring Boot.
 * Ela é responsável por buscar todos os jogos (Game) no banco de dados e convertê-los para objetos
 * GameMinDTO, que contêm apenas informações resumidas de cada jogo. Esta classe atua
 * como intermediária entre o repositório (acesso ao banco) e o controlador (interface com o usuário
 * ou API).
 */

@Service
public class GameService {

    // Injeta automaticamente uma instância do GameRepository
    @Autowired
    private GameRepository gameRepository;

    // Método público que retorna uma lista de jogos em forma de DTO resumido
    public List<GameMinDTO> findAll() {

        // Busca todos os jogos do banco de dados
        List<Game> result = gameRepository.findAll();

        // Converte a lista de entidades Game para uma lista de GameMinDTO
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
