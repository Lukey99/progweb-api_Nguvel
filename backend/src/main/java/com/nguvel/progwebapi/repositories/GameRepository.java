package com.nguvel.progwebapi.repositories;

import com.nguvel.progwebapi.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
