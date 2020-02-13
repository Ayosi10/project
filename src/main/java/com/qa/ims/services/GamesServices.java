package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Games;

public class GamesServices implements CrudServices<Games> {

	private Dao<Games> gameDao;
	
	public GamesServices(Dao<Games> gameDao) {
		this.gameDao = gameDao;
	}
	
	public List<Games> readAll() {
		return gameDao.readAll();
	}

	public Games create(Games games) {
		return gameDao.create(games);
	}

	public Games update(Games games) {
		return gameDao.update(games);
	}

	public void delete(Long game_id) {
		gameDao.delete(game_id);
	}

}
