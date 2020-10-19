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
	

	@GetMapping("/getMenu")
	public ResponseEntity<List<Menu>> getMenu() {
		return ResponseEntity.ok(this.service.getMenu());

	}

	@PostMapping("/createMenu")
	public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {

		return new ResponseEntity<Menu>(this.service.createMenu(menu), HttpStatus.CREATED);

	}

	@PutMapping("/updateMenu")
	public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu, @PathParam("id") Long id) {
		return new ResponseEntity<Menu>(this.service.updateMenu(menu, id), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/removeMenu/{id}")
	public ResponseEntity<Object> deleteMenu(@PathVariable Long id) {
		if (this.service.deleteMenu(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
