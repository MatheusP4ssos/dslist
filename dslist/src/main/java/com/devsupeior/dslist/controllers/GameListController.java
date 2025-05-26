package com.devsupeior.dslist.controllers;

import com.devsupeior.dslist.dto.GameListDto;
import com.devsupeior.dslist.dto.GameMinDTO;
import com.devsupeior.dslist.dto.ReplacementDTO;
import com.devsupeior.dslist.projections.GameMinProjection;
import com.devsupeior.dslist.services.GameListService;
import com.devsupeior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável por gerenciar as requisições relacionadas à entidade Game.
 * <p>
 * Expõe endpoints HTTP para buscar a lista de jogos.
 * O caminho base para as requisições deste controlador é "/games".
 */

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    // Injeta automaticamente a dependência do serviço que contém a lógica de negócios para Gamelist
    private GameListService gamelistService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDto> findAll() {
        // Chama o serviço para buscar todos os jogos resumidos
        List<GameListDto> result = gamelistService.findAll(); // Retorna a lista para o cliente
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId,@RequestBody ReplacementDTO body) {
        gamelistService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}

