package com.nguvel.progwebapi.controllers;

import com.nguvel.progwebapi.exceptions.RessourceNotFoundException;
import com.nguvel.progwebapi.models.Game;
import com.nguvel.progwebapi.models.User;
import com.nguvel.progwebapi.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @CrossOrigin
    @PostMapping("/game")
    public Game createGame(@Valid @RequestBody Game game){
        Game game1 = gameRepository.save(game);
        return game1;
    }

    @CrossOrigin
    @GetMapping("/game")
    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }
    @CrossOrigin
    @GetMapping("/game/{game_id}")
    public Game getById(@PathVariable Long game_id){
        Game game = gameRepository.getOne(game_id);
        return game;
    }

    @CrossOrigin
    @DeleteMapping("/game")
    public ResponseEntity<?> deleteGame(@PathVariable Long game_id){
        return gameRepository.findById(game_id)
                .map(game -> {
                    gameRepository.delete(game);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new RessourceNotFoundException("Game not found with id " + game_id));
    }
}
