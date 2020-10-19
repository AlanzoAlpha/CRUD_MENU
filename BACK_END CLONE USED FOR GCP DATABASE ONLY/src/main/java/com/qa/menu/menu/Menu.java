package com.qa.menu.menu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	private int dishNumber;

	private String dishName;

	private String veganSuitability;

	private int dishPrice;

	public Menu() {
		super();
	}

	public Menu(int dishNumber, String dishName, String veganSuitability, int dishPrice) {
		super();
		this.dishNumber = dishNumber;
		this.dishName = dishName;
		this.veganSuitability = veganSuitability;
		this.dishPrice = dishPrice;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Menu [dishNumber=" + dishNumber + ", dishName=" + dishName + ", veganSuitability=" + veganSuitability
				+ ", dishPrice=" + dishPrice + "]";
	}

	public int getDishNumber() {
		return dishNumber;
	}

	public void setDishNumber(int dishNumber) {
		this.dishNumber = dishNumber;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getVeganSuitability() {
		return veganSuitability;
	}

	public void setVeganSuitability(String veganSuitability) {
		this.veganSuitability = veganSuitability;
	}

	public int getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(int dishPrice) {
		this.dishPrice = dishPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dishName == null) ? 0 : dishName.hashCode());
		result = prime * result + dishNumber;
		result = prime * result + dishPrice;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((veganSuitability == null) ? 0 : veganSuitability.hashCode());
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
		Menu other = (Menu) obj;
		if (dishName == null) {
			if (other.dishName != null)
				return false;
		} else if (!dishName.equals(other.dishName))
			return false;
		if (dishNumber != other.dishNumber)
			return false;
		if (dishPrice != other.dishPrice)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (veganSuitability == null) {
			if (other.veganSuitability != null)
				return false;
		} else if (!veganSuitability.equals(other.veganSuitability))
			return false;
		return true;
	}

}
