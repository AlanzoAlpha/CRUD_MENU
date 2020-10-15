package com.qa.wood.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.wood.menu.Menu;

public interface MenuRepo extends JpaRepository<Menu, Long> {

	List<Menu> findByDishName(String dishName);
}
