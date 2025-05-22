package com.devsupeior.dslist.controllers;

import com.devsupeior.dslist.dto.GameMinDTO;
import com.devsupeior.dslist.entities.Game;
import com.devsupeior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST responsável por gerenciar as requisições relacionadas à entidade Game.
 * <p>
 * Expõe endpoints HTTP para buscar a lista de jogos.
 * O caminho base para as requisições deste controlador é "/games".
 */

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    // Injeta automaticamente a dependência do serviço que contém a lógica de negócios para Game
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        // Chama o serviço para buscar todos os jogos resumidos

        List<GameMinDTO> result = gameService.findAll(); // Retorna a lista para o cliente
        return result;

    }
}
