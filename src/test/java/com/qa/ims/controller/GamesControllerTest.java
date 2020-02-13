package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


import com.qa.ims.persistence.domain.Games;

import com.qa.ims.services.GamesServices;

//@RunWith(MockitoJUnitRunner.class)
//public class GamesControllerTest {
//	
//	/**
//	 *  The thing I want to fake functionlity for
//	 */
//	@Mock
//	private GamesServices gamesServices;
//	
//	/**
//	 * Spy is used because i want to mock some methods inside the item I'm testing
//	 * InjectMocks uses dependency injection to insert the mock into the customer controller
//	 */
//	@Spy
//	@InjectMocks
//	private GamesController gamesController;
//
//	@Test
//	public void readAllTest() {
//		GamesController gamesController = new GamesController(gamesServices);
//		List<Games> games = new ArrayList<>();
//		games.add(new Games("Mason", "30"));
//		games.add(new Games("Tammy", "80"));
//		games.add(new Games("Lionel", "60"));
//		Mockito.when(gamesServices.readAll()).thenReturn(games);
//		assertEquals(games, gamesController.readAll());
//	}
//
//	@Test
//	public void createTest() {
//		String game_name = "Fifa 20";
//		String cost = "10";
//		Mockito.doReturn(game_name, cost).when(gamesController).getInput();
//		Games game = new Games(game_name, cost);
//		Games savedGames = new Games(1L, "Mason", "30");
//		Mockito.when(gamesServices.create(game)).thenReturn(savedGames);
//		assertEquals(savedGames, gamesController.create());
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void updateTest() {
//		String game_id = "1";
//		String game_name = "Michael";
//		String cost = "40";
//		Mockito.doReturn(game_id, game_name, cost).when(gamesController).getInput();
//		Games game = new Games(1L, "Mason", "30");
//		Mockito.when(gamesServices.update(game)).thenReturn(game);
//		assertEquals(game, gamesController.update());
//	}
//	
//
//	/**
//	 * Delete doesn't return anything, so we can just verify that it calls the delete method
//	 */
//	@Test
//	public void deleteTest() {
//		String id = "1";
//		Mockito.doReturn(id).when(gamesController).getInput();
//		gamesController.delete();
//		Mockito.verify(gamesServices, Mockito.times(1)).delete(1L);
//	}
//	
//}
