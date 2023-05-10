package com.dessuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dessuperior.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
