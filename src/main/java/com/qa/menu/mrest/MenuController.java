package com.qa.menu.mrest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.menu.menu.Menu;
import com.qa.menu.services.MenuServices;

@CrossOrigin
@RestController
public class MenuController {

	private MenuServices service;

	public MenuController(MenuServices service) {
		super();
		this.service = service;
	}
//  Trial code
//	@GetMapping("/Hello")
//	public String greeting() {
//		return "Hello, World!";
//	}

//	@GetMapping("/menu/{ishName}")
//	public List<Menu> getDishByName(@PathVariable String dishName) {
//		return this.service.getDishByName(dishName);
//	}

	@GetMapping("/getMenu")
	public ResponseEntity<List<Menu>> getMenu() {
		// return this.service.getWood();
		return ResponseEntity.ok(this.service.getMenu());
//	public List<Menu> getMenu() {
//		return this.service.getMenu();

		// return new Menu(1,"Fish&Chip", No, 12);
	}

	@PostMapping("/createMenu")
	public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {

		return new ResponseEntity<Menu>(this.service.createMenu(menu), HttpStatus.CREATED);
//		public void createMenu(@RequestBody Menu menu) {
//		System.out.println(menu);
//		this.service.createMenu(menu);
	}

	@PutMapping("/updateMenu")
	public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu, @PathParam("id") Long id) {
		return new ResponseEntity<Menu>(this.service.updateMenu(menu, id), HttpStatus.ACCEPTED);
//	public void updateMenu(@RequestBody Menu menu, @PathParam("id") Long id) {
////		this.menuDB.remove(id);
////		this.menuDB.add(id, menu);
////		System.out.println(menu);
//		this.service.updateMenu(menu, id);
	}

	@DeleteMapping("/removeMenu/{id}")
	public ResponseEntity<Object> deleteMenu(@PathVariable Long id) {
		if (this.service.deleteMenu(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
////	public void deleteMenu(@PathVariable Long id) {
////		this.menuDB.remove(id);
////		this.service.deleteMenu(id);
//	}

}
