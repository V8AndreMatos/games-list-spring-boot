package com.game.list.controller;

import com.game.list.dto.GameDTO;
import com.game.list.dto.GameDTOAllFiles;
import com.game.list.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTOAllFiles findById(@PathVariable Long id){
       GameDTOAllFiles result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameDTO> findAll(){
        List<GameDTO> result = gameService.findAll();
        return result;
    }

}
