package com.dessuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dessuperior.dslist.dto.GameListDTO;
import com.dessuperior.dslist.dto.GameMinDTO;
import com.dessuperior.dslist.projections.GameMinProjection;
import com.dessuperior.dslist.services.GameListService;
import com.dessuperior.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists") // caminhaPraAPI
public class GameListController {


	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;

	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listsId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listsId){
		List<GameMinDTO> result = gameService.findByList(listsId);
		return result;
	}
}
