package com.qa.wood.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.wood.domain.MenuRepo;
import com.qa.wood.menu.Menu;

@Service
public class MenuServices {
	private MenuRepo repo;

	public MenuServices(MenuRepo repo) {
		super();
		this.repo = repo;
	}

	public Menu createMenu(Menu menu) {
		return this.repo.save(menu);
	}

	public List<Menu> getMenu() {
		return this.repo.findAll();
	}

	public Menu updateMenu(Menu menu, Long id) {
		Menu islandGrilMenu = this.repo.findById(id).get();
		islandGrilMenu.setDishNumber(menu.getDishNumber());
		islandGrilMenu.setDishName(menu.getDishName());
		islandGrilMenu.setVeganSuitability(menu.getVeganSuitability());
		islandGrilMenu.setDishPrice(menu.getDishPrice());

		return this.repo.save(islandGrilMenu);

	}

	public boolean deleteMenu(Long id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}

	public List<Menu> getDishByName(String dishName) {
		return this.repo.findByDishName(dishName);

	}

}
