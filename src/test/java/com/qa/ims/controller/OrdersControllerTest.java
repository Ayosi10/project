//package com.qa.ims.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.MockitoJUnitRunner;
//
//
//import com.qa.ims.persistence.domain.Orders;
//
//import com.qa.ims.services.OrdersServices;
//
//@RunWith(MockitoJUnitRunner.class)
//public class OrdersControllerTest {
//	
//	/**
//	 *  The thing I want to fake functionlity for
//	 */
//	@Mock
//	private OrdersServices ordersServices;
//	
//	/**
//	 * Spy is used because i want to mock some methods inside the item I'm testing
//	 * InjectMocks uses dependency injection to insert the mock into the customer controller
//	 */
//	@Spy
//	@InjectMocks
//	private OrdersController ordersController;
//
//	@Test
//	public void readAllTest() {
//		OrdersController ordersController = new OrdersController(ordersServices);
//		List<Orders> orders = new ArrayList<>();
//		orders.add(new Orders("Fifa", "20"));
//		orders.add(new Orders("Tammy", "30"));
//		orders.add(new Orders("Lionel", "60"));
//		Mockito.when(ordersServices.readAll()).thenReturn(orders);
//		assertEquals(orders, ordersController.readAll());
//	}
//
//	@Test
//	public void createTest() {
//		String Customer_id = "2";
//		String totalcost = "150";
//		String number_of_games = "10";
//		Mockito.doReturn(Customer_id, totalcost, number_of_games).when(ordersController).getInput();
//		Orders orders = new Orders(Customer_id, totalcost, number_of_games);
//		Orders savedOrders = new Orders(1L,"2", "150", "10");
//		Mockito.when(ordersServices.create(orders)).thenReturn(savedOrders);
//		assertEquals(savedOrders, ordersController.create());
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void updateTest() {
//		String orders_id = "1";
//		String Customer_id = "1";
//		String totalcost = "100";
//		String number_of_games = "2";
//		Mockito.doReturn(orders_id, Customer_id, totalcost, number_of_games).when(ordersController).getInput();
//		Orders orders = new Orders(1L,"1","2", "150", "10");
//		Mockito.when(ordersServices.update(orders)).thenReturn(orders);
//		assertEquals(orders, ordersController.update());
//	}
//	
//
//	/**
//	 * Delete doesn't return anything, so we can just verify that it calls the delete method
//	 */
//	@Test
//	public void deleteTest() {
//		String id = "1";
//		Mockito.doReturn(id).when(ordersController).getInput();
//		ordersController.delete();
//		Mockito.verify(ordersServices, Mockito.times(1)).delete(1L);
//	}
//	
//}
