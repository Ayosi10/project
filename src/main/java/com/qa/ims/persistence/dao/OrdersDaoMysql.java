package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Games;
import com.qa.ims.persistence.domain.Orders;

public class OrdersDaoMysql implements Dao<Orders> {

	public static final Logger LOGGER = Logger.getLogger(OrdersDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrdersDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.246.123.129:3306/ims";
		this.username = username;
		this.password = password;
	}

	public OrdersDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Orders ordersFromResultSet(ResultSet resultSet) throws SQLException {
		Long orders_id = resultSet.getLong("Orders_id");
		Long customer_id = resultSet.getLong("Customer_id");
		Long totalcost = resultSet.getLong("totalcost");
		Long number_of_games = resultSet.getLong("number_of_games");
		return new Orders(orders_id, customer_id, totalcost, number_of_games);
	}

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	@Override
	public List<Orders> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from Orders");) {
			ArrayList<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(ordersFromResultSet(resultSet));
			}
			return orders;
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
	public Orders create(Orders order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into Orders (customer_id, totalcost, number_of_games) values('" + order.getCustomer_Id()
					+ "','" + order.getTotalCost() + "', '" + order.getNumber_of_Games() + "')");
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
	public Orders update(Orders order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE Orders SET customer_id ='" + order.getCustomer_Id() + "', totalcost ='"
					+ order.getTotalCost() + "', number_of_games ='" + order.getNumber_of_Games() + "' where orders_id =" + order.getOrders_Id());
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
	public void delete(long orders_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from Orders where orders_id = " + orders_id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

}
