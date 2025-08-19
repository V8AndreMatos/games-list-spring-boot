package com.game.list.service;

import com.game.list.dto.GameDTO;
import com.game.list.entities.Game;
import com.game.list.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameDTO> findAll(){

        List<Game> result = gameRepository.findAll();
        List<GameDTO> dtoList = result.stream().map(x -> new GameDTO(x)).toList();

        return dtoList;

    }

}
