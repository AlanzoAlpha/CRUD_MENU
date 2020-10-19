package com.qa.menu.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.menu.menu.Menu;

public interface MenuRepo extends JpaRepository<Menu, Long> {

	List<Menu> findByDishName(String dishName);
}
