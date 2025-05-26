package com.devsupeior.dslist.services;

import com.devsupeior.dslist.dto.GameListDto;
import com.devsupeior.dslist.entities.GameList;
import com.devsupeior.dslist.projections.GameMinProjection;
import com.devsupeior.dslist.repositories.GameListRepository;
import com.devsupeior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Serviço responsável por operações relacionadas à entidade GameList.
 * Atua como intermediário entre os repositórios (acesso ao banco de dados) e os controladores (camada web/API).
 */
@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository; // Repositório para acesso à tabela tb_game_list

    @Autowired
    private GameRepository gameRepository; // Repositório para acesso a jogos (tb_game)

    /**
     * Retorna todas as listas de jogos do banco, convertidas para DTOs.
     * A anotação @Transactional(readOnly = true) evita bloqueios de escrita e melhora a performance.
     */
    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        List<GameList> result = gameListRepository.findAll(); // Busca todas as listas
        return result.stream().map(GameListDto::new).toList(); // Converte para DTO e retorna
    }

    /**
     * Reorganiza a posição de um jogo dentro de uma lista específica.
     *
     * @param listId         ID da lista que será modificada
     * @param sourceIndex    Índice atual do jogo na lista
     * @param destinationIndex Novo índice desejado
     */
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        // Busca os jogos da lista (com suas posições), usando projeção
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        // Remove o jogo da posição original
        GameMinProjection obj = list.remove(sourceIndex);

        // Insere o jogo na nova posição
        list.add(destinationIndex, obj);

        // Determina os limites para reordenar apenas os afetados
        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        // Atualiza no banco a nova ordem para os jogos que mudaram de posição
        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
