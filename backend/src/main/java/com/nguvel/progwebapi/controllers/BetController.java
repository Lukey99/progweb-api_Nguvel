package com.nguvel.progwebapi.controllers;

import com.nguvel.progwebapi.exceptions.RessourceNotFoundException;
import com.nguvel.progwebapi.models.Bet;
import com.nguvel.progwebapi.models.Game;
import com.nguvel.progwebapi.repositories.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BetController {

    @Autowired
    private BetRepository betRepository;

    @CrossOrigin
    @PostMapping("/bet")
    public Bet createBet(@Valid @RequestBody Bet bet){
        Bet bet1 = betRepository.save(bet);
        return bet1;
    }

    @CrossOrigin
    @GetMapping("/bet")
    public List<Bet> getAllBets() {
        return betRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/bet/{bet_id}")
    public Bet getById(@PathVariable Long bet_id){
        Bet bet = betRepository.getOne(bet_id);
        return bet;
    }

    @CrossOrigin
    @DeleteMapping("/bet")
    public ResponseEntity<?> deleteBet(@PathVariable Long bet_id){
        return betRepository.findById(bet_id)
                .map(bet -> {
                    betRepository.delete(bet);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new RessourceNotFoundException("Bet not found with id " + bet_id));
    }
}
