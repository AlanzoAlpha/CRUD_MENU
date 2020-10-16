package com.qa.menu.menu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Object Relational Mapper (ORM) -  This converts classes to tables.

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // setting the id field to AUTO_INCREMENT
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

}
