package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Games;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.CrudServices;
import com.qa.ims.services.OrdersServices;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class OrdersController implements CrudController<Orders>{

	public static final Logger LOGGER = Logger.getLogger(OrdersController.class);


	
	
	private CrudServices<Orders> OrdersServices;
	
	public OrdersController(CrudServices<Orders> OrdersServices) {
		this.OrdersServices = OrdersServices;
	}
	




	String getInput() {
		return Utils.getInput();
	}
	
	/**
	 * Reads all customers to the logger
	 */

	public List<Orders> readAll() {
		List<Orders> orders = OrdersServices.readAll();
		for(Orders order: orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Orders create() {
		LOGGER.info("Please enter the Customer_id of the Orders you would like to create");
		Long Customer_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the totalcost of the Orders you would like to create");
		Long totalcost = Long.valueOf(getInput());
		LOGGER.info("Please enter the numberofgames of the Orders you would like to create");
		Long number_of_games = Long.valueOf(getInput());
		Orders orders = OrdersServices.create(new Orders(Customer_id,totalcost,number_of_games));
		LOGGER.info("Orders created");
		return orders;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Orders update() {
		LOGGER.info("Please enter the orders_id of the Orders you would like to update");
		Long orders_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the customer_id of the Orders you would like to update");
		Long Customer_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the totalcost of the Orders you would like to update");
		Long totalcost = Long.valueOf(getInput());
		LOGGER.info("Please enter the numberofgames of the Orders you would like to update");
		Long number_of_games = Long.valueOf(getInput());
		Orders orders = OrdersServices.update(new Orders(orders_id,Customer_id,totalcost,number_of_games));
		LOGGER.info("Orders updated");
		return orders;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the order_id of the Orders you would like to delete");
		Long orders_id = Long.valueOf(getInput());
		OrdersServices.delete(orders_id);
		LOGGER.info("Orders Deleted" + "");
	}
	
}
