package com.dessuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessuperior.dslist.dto.GameDTO;
import com.dessuperior.dslist.dto.GameListDTO;
import com.dessuperior.dslist.dto.GameMinDTO;
import com.dessuperior.dslist.entities.Game;
import com.dessuperior.dslist.entities.GameList;
import com.dessuperior.dslist.repositories.GameListRepository;
import com.dessuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x->new GameListDTO(x)).toList();
		
	}

}
