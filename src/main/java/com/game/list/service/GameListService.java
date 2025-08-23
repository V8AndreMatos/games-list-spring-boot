package com.game.list.service;

import com.game.list.dto.GameDTO;
import com.game.list.dto.GameDTOAllFiles;
import com.game.list.dto.GameListDTO;
import com.game.list.entities.Game;
import com.game.list.entities.GameList;
import com.game.list.projection.GameProjection;
import com.game.list.repository.GameListRepository;
import com.game.list.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
       return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    //Metodo para atualizar os jogos no banco de dados
    public void moveGame(Long listId , int sourceIndex , int destinationIndex){

        //Traz os games da memória
        List<GameProjection> list = gameRepository.searchByList(listId);

        //2 linhas abaixo atualizado na memória
        GameProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex , obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex > destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min ; i <= max ; i++){

            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
