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
 * Serviço responsável por operações relacionadas à entidade Game.
 * Atua como intermediário entre o repositório (persistência) e os controladores (API).
 */

@Service
public class GameListService {

    // Injeta automaticamente uma instância do GameRepository
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    // Método público que retorna uma lista de jogos em forma de DTO resumido
    @Transactional(readOnly = true)//Grante integridade com conceitos ACID
    public List<GameListDto> findAll() {
        // Busca todos as listas de jogos do banco de dados
        List<GameList> result = gameListRepository.findAll();
        // Converte a lista de entidades Gamelist para uma lista de DTO
        return result.stream().map(x -> new GameListDto(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

      GameMinProjection obj = list.remove(sourceIndex);
      list.add(destinationIndex, obj);

      int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
      int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

      for ( int i = min; i <= max; i++ ) {
          gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
      }
    }
}
