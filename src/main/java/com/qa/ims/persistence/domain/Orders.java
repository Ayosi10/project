package com.qa.ims.persistence.domain;

public class Orders {

	private Long Orders_id;
	private Long Customer_id;
	private Long totalcost;
	private Long number_of_games;
	public Orders(Long customer_id, Long totalcost, Long number_of_games) {
		this.Customer_id = customer_id;
		this.totalcost = totalcost;
		this.number_of_games = number_of_games;
	}
	public Orders(Long orders_id, Long customer_id, Long totalcost, Long number_of_games) {
		this.Orders_id = orders_id;
		this.Customer_id = customer_id;
		this.totalcost = totalcost;
		this.number_of_games = number_of_games;
	}
	
	

	public Long getOrders_Id() {
		return Orders_id;
	}

	public void setOrders_Id(Long orders_id) {
		this.Orders_id = orders_id;
	}

	public Long getCustomer_Id() {
		return Customer_id;
	}

	public void setCustomer_Id(Long customer_id) {
		this.Customer_id = customer_id;
	}

	public Long getTotalCost() {
		return totalcost;
	}

	public void setTotalCost(Long totalcost) {
		this.totalcost = totalcost;
	}
	public Long getNumber_of_Games() {
		return number_of_games;
	}

	public void setNumber_of_Games(Long number_of_games) {
		this.number_of_games = number_of_games;
	}
	public Orders(Long totalcost) {
		this.totalcost = totalcost;
	}

	public Orders(String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	public Orders(long l, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}
	public Orders(String customer_id2, String totalcost2, String number_of_games2) {
		// TODO Auto-generated constructor stub
	}
	public Orders(long l, String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "Orders_id:" + Orders_id + " Customer_id:" + Customer_id + " totalcost:" + totalcost + "number_of_games:" + number_of_games;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Orders_id == null) ? 0 : Orders_id.hashCode());
		result = prime * result + ((Customer_id == null) ? 0 : Customer_id.hashCode());
		result = prime * result + ((totalcost == null) ? 0 : totalcost.hashCode());
		result = prime * result + ((number_of_games == null) ? 0 : number_of_games.hashCode());
		return result;
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (Orders_id == null) {
			if (other.Orders_id != null)
				return false;
		} else if (!Orders_id.equals(other.Orders_id))
			return false;
		if (Orders_id == null) {
			if (other.Orders_id != null)
				return false;
		} else if (!Orders_id.equals(other.Orders_id))
			return false;
		if (totalcost == null) {
			if (other.totalcost != null)
				return false;
		} else if (!totalcost.equals(other.totalcost))
			return false;
		if (number_of_games == null) {
			if (other.number_of_games != null)
				return false;
		} else if (!number_of_games.equals(other.number_of_games))
			return false;
		return true;
	}

}
