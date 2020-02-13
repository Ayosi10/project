package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Games;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class GamesController implements CrudController<Games>{

	public static final Logger LOGGER = Logger.getLogger(GamesController.class);


	
	
	private CrudServices<Games> GamesServices;
	
	public GamesController(CrudServices<Games> GamesServices) {
		this.GamesServices = GamesServices;
	}
	




	String getInput() {
		return Utils.getInput();
	}
	
	/**
	 * Reads all customers to the logger
	 */

	public List<Games> readAll() {
		List<Games> games = GamesServices.readAll();
		for(Games game: games) {
			LOGGER.info(game.toString());
		}
		return games;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Games create() {
		LOGGER.info("Please enter a game_name");
		String game_name = getInput();
		LOGGER.info("Please enter a cost");
		Long cost = Long.valueOf(getInput());
		Games game = GamesServices.create(new Games(game_name, cost));
		LOGGER.info("Games created");
		return game;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Games update() {
		LOGGER.info("Please enter the id of the Games you would like to update");
		Long game_id = Long.valueOf(getInput());
		LOGGER.info("Please enter a game_name");
		String game_name = getInput();
		LOGGER.info("Please enter a cost");
		Long cost = Long.valueOf(getInput());
		Games games = GamesServices.update(new Games(game_id, game_name, cost));
		LOGGER.info("Games Updated");
		return games;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the Games you would like to delete");
		Long game_id = Long.valueOf(getInput());
		GamesServices.delete(game_id);
		LOGGER.info("Games Deleted" + "");
	}
	
}
