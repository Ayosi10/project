package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Games;

public class GamesDaoMysql implements Dao<Games> {

	public static final Logger LOGGER = Logger.getLogger(GamesDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public GamesDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.246.123.129:3306/ims";
		this.username = username;
		this.password = password;
	}

	public GamesDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Games gamesFromResultSet(ResultSet resultSet) throws SQLException {
		Long game_id = resultSet.getLong("game_id");
		String game_name = resultSet.getString("game_name");
		Long cost = resultSet.getLong("cost");
		return new Games(game_id, game_name, cost);
	}

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	@Override
	public List<Games> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from Games");) {
			ArrayList<Games> games = new ArrayList<>();
			while (resultSet.next()) {
				games.add(gamesFromResultSet(resultSet));
			}
			return games;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}


	/**
	 * Creates a customer in the database
	 * 
	 * @param customer - takes in a customer object. id will be ignored
	 */
	@Override
	public Games create(Games game) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into Games(game_name, cost) values('" + game.getGame_Name()
					+ "','" + game.getCost() + "')");
	
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}


	

	/**
	 * Updates a customer in the database
	 * 
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */

	@Override
	public Games update(Games game) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE Games SET game_name ='" + game.getGame_Name() + "', cost ='"
					+ game.getCost() + "' where game_id =" + game.getGame_Id());
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	@Override
	public void delete(long game_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from Games where game_id = " + game_id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

}
