//package com.qa.menu.mservice;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ActiveProfiles;
//
//import com.qa.menu.domain.MenuRepo;
//import com.qa.menu.menu.Menu;
//import com.qa.menu.services.MenuServices;
//
//@SpringBootTest
//@ActiveProfiles(profiles = "test")
//public class MenuServiceUnitTest {
//
//	@Autowired
//	private MenuServices service;
//
//	@MockBean
//	private MenuRepo repo;
//
//	// GIVEN - WHEN - THEN
//	@Test
//	void testCreate() {
//		// GIVEN
//		Long id = 1L;
//		Menu newMenu = new Menu(1, "Fish&Chips", "No", 12);
//		Menu savedMenu = new Menu(1, "Fish&Chips", "No", 12);
//		savedMenu.setId(id);
//
//		// WHEN
//		Mockito.when(this.repo.save(newMenu)).thenReturn(savedMenu);
//
//		// THEN
//		assertThat(this.service.createMenu(newMenu)).isEqualTo(savedMenu);
//
//		Mockito.verify(this.repo, Mockito.times(1)).save(newMenu);
//	}
//
//	@Test
//	void testUpdate() {
//		// GIVEN
//
//		Long id = 1L;
//
//		// will be passed in
//		Menu newMenu = new Menu(1, "Fish&Chips", "No", 12);
//		// will be found by findById()
//		Menu oldMenu = new Menu(1, "Fish&Chips", "No", 12);
//		oldMenu.setId(id);
//		// will be saved back to db and returned by method
//		Menu updatedMenu = new Menu(1, "Fish&Chips", "No", 12);
//		updatedMenu.setId(id);
//
//		// WHEN
//		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(oldMenu));
//		Mockito.when(this.repo.save(updatedMenu)).thenReturn(updatedMenu);
//
//		// THEN
//		assertThat(this.service.updateMenu(newMenu, id)).isEqualTo(updatedMenu);
//
//		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
//		Mockito.verify(this.repo, Mockito.times(1)).save(updatedMenu);
//	}
//
//	@Test
//	void testGet() {
//		// GIVEN
//		Menu menu = new Menu(1, "Fish&Chips", "No", 12);
//		menu.setId(1L); // wood object to match the one in menu-data.sql
//		List<Menu> menus = new ArrayList<>();
//		menus.add(menu);
//
//		// WHEN
//		Mockito.when(this.repo.findAll()).thenReturn(menus);
//
//		// THEN
//		assertThat(this.service.getMenu()).isEqualTo(menus);
//
//		Mockito.verify(this.repo, Mockito.times(1)).findAll();
//	}
//
//	@Test
//	void testDelete() {
//		// GIVEN
//		Long id = 1L;
//		boolean found = false;
//
//		// WHEN
//		Mockito.when(this.repo.existsById(id)).thenReturn(found);
//
//		// THEN
//		assertThat(this.service.deleteMenu(id)).isEqualTo(!found);
//
//		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
//	}
//}
