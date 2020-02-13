package com.qa.ims.persistence.domain;

public class Games {

	private Long game_id;
	private String Game_Name;
	private Long cost;

	public Games(String Game_Name, Long cost) {
		this.Game_Name = Game_Name;
		this.cost = cost;
	}





	public Games(long l, String game_name2, Long cost) {
		// TODO Auto-generated constructor stub
	}





	public Games(String game_Name2, String string) {
		// TODO Auto-generated constructor stub
	}





	public Games(long l, String string, String string2) {
		// TODO Auto-generated constructor stub
	}





	public Long getGame_Id() {
		return game_id;
	}

	public void setId(Long game_id) {
		this.game_id = game_id;
	}

	public String getGame_Name() {
		return Game_Name;
	}

	public void setGame_Name(String Game_Name) {
		this.Game_Name = Game_Name;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public String toString() {
		return "game_id:" + game_id + " Game_Name:" + Game_Name + " cost:" + cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Game_Name == null) ? 0 : Game_Name.hashCode());
		result = prime * result + ((game_id == null) ? 0 : game_id.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
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
		Games other = (Games) obj;
		if (Game_Name == null) {
			if (other.Game_Name != null)
				return false;
		} else if (!Game_Name.equals(other.Game_Name))
			return false;
		if (game_id == null) {
			if (other.game_id != null)
				return false;
		} else if (!game_id.equals(other.game_id))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		return true;
	}

}
