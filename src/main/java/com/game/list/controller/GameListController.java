package com.game.list.controller;

import com.game.list.dto.GameDTO;
import com.game.list.dto.GameDTOAllFiles;
import com.game.list.dto.GameListDTO;
import com.game.list.dto.GameReplacementDTO;
import com.game.list.service.GameListService;
import com.game.list.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{listId}/games")
    public List<GameDTO> findByList(@PathVariable Long listId){
        List<GameDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void moveGames(@PathVariable Long listId , @RequestBody GameReplacementDTO body){
        gameListService.moveGame(listId , body.getSourceIndex(), body.getDestinationIndex());

    }
}
