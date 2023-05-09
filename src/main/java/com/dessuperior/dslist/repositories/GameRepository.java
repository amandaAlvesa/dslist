package com.dessuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dessuperior.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
