package com.qa.menu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.menu.domain.MenuRepo;
import com.qa.menu.exceptions.MenuNotFoundException;
import com.qa.menu.menu.Menu;

@Service
public class MenuServices {

	@Autowired
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
		Optional<Menu> optWood = this.repo.findById(id);
		Menu islandGrilMenu = optWood.orElseThrow(() -> new MenuNotFoundException());
		islandGrilMenu.setDishNumber(menu.getDishNumber());
		islandGrilMenu.setDishName(menu.getDishName());
		islandGrilMenu.setVeganSuitability(menu.getVeganSuitability());
		islandGrilMenu.setDishPrice(menu.getDishPrice());

		Menu saved = this.repo.save(islandGrilMenu);

		return saved;

	}

	public boolean deleteMenu(Long id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}

	public List<Menu> getDishByName(String dishName) {
		return this.repo.findByDishName(dishName);

	}

}
