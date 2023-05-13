package com.dessuperior.dslist.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessuperior.dslist.dto.GameDTO;
import com.dessuperior.dslist.dto.GameListDTO;
import com.dessuperior.dslist.dto.GameMinDTO;
import com.dessuperior.dslist.entities.Game;
import com.dessuperior.dslist.entities.GameList;
import com.dessuperior.dslist.projections.GameMinProjection;
import com.dessuperior.dslist.repositories.GameListRepository;
import com.dessuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x->new GameListDTO(x)).toList();
		
	}

	@Transactional
	public void move(Long listId, int sourceIndex, int destinationSource) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);		
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationSource, obj);
		
		int min = sourceIndex < destinationSource ? sourceIndex : destinationSource;
		int max = sourceIndex < destinationSource ? destinationSource : sourceIndex;
	
		for (int i = min; i<= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
