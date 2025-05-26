package com.devsupeior.dslist.dto;

import com.devsupeior.dslist.entities.GameList;
import org.springframework.beans.BeanUtils;

/**
 * DTO (Data Transfer Object) que representa uma versão simplificada da entidade {@link GameList}.
 * <p>Essa classe é usada para transferir dados de listas de jogos entre as camadas da aplicação,
 * especialmente entre a camada de serviço e os controladores (API REST), evitando a exposição
 * direta da entidade {@code GameList}.</p>
 * <p>Contém apenas os campos essenciais: {@code id} e {@code name}, suficientes para exibição
 * ou seleção de listas em interfaces de usuário ou consumo por APIs.</p>
 * <p>O construtor utiliza {@link BeanUtils#copyProperties(Object, Object)} para copiar os dados
 *  diretamente da entidade original.</p>
 */
public class GameListDto {

    private Long id;
    private String name;

    public GameListDto() {
    }

    // Construtor que copia os dados da entidade GameList
    public GameListDto(GameList gameList) {
     BeanUtils.copyProperties(gameList, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
