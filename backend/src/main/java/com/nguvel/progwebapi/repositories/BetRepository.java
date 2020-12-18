package com.nguvel.progwebapi.repositories;

import com.nguvel.progwebapi.models.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long> {
}
