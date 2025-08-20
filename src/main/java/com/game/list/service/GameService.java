package com.game.list.service;

import com.game.list.dto.GameDTO;
import com.game.list.dto.GameDTOAllFiles;
import com.game.list.entities.Game;
import com.game.list.projection.GameProjection;
import com.game.list.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTOAllFiles findById(Long id){
        Game result = gameRepository.findById(id).get();
        GameDTOAllFiles gameDTOAllFiles = new GameDTOAllFiles(result);
        return gameDTOAllFiles;
    }

    @Transactional(readOnly = true)
    public List<GameDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameDTO> dtoList = result.stream().map(x -> new GameDTO(x)).toList();
        return dtoList;
    }

    @Transactional(readOnly = true)
    public List<GameDTO> findByList(Long listId){
        List<GameProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameDTO(x)).toList();

    }

}
