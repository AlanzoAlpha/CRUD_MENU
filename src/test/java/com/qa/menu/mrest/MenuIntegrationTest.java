package com.qa.menu.mrest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.menu.menu.Menu;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:menu-schema.sql",
		"classpath:menu-dish.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class MenuIntegrationTest {
	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Menu newMenu = new Menu(1, "Fish&Chips", "No", 12);
		String requestJson = this.mapper.writeValueAsString(newMenu);
		RequestBuilder request = post("/createMenu").contentType(MediaType.APPLICATION_JSON).content(requestJson);

		ResultMatcher checkStatus = status().is(201);

		Menu savedMenu = new Menu(1, "Fish&Chips", "No", 12);
		savedMenu.setId(2L); // id = 2 because 1 value is inserted using data.sql

		String resultJson = this.mapper.writeValueAsString(savedMenu);
		ResultMatcher checkBody = content().json(resultJson);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

		MvcResult result = this.mockMVC.perform(request).andExpect(checkStatus).andReturn();

		// In case you need to access the actual result as an object:
		String reqBody = result.getResponse().getContentAsString();

		Menu menuResult = this.mapper.readValue(reqBody, Menu.class);
	}

	@Test
	void testUpdate() throws Exception {
		Menu newMenu = new Menu(1, "Fish&Chips", "No", 12);
		String requestJson = this.mapper.writeValueAsString(newMenu);
		RequestBuilder request = put("/updateMenu?id=1").contentType(MediaType.APPLICATION_JSON).content(requestJson);

		ResultMatcher checkStatus = status().isAccepted();

		Menu savedMenu = new Menu(1, "Fish&Chips", "No", 12);
		savedMenu.setId(1L); // id = 1 because we're updating the value inserted using data.sql

		String resultJson = this.mapper.writeValueAsString(savedMenu);
		ResultMatcher checkBody = content().json(resultJson);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {
		RequestBuilder request = delete("/removeMenu/1");

		ResultMatcher checkStatus = status().is(200);

		this.mockMVC.perform(request).andExpect(checkStatus);

//		ResultMatcher checkStatus2 = status().is(500);
//
//		this.mockMVC.perform(request).andExpect(checkStatus);
	}

	@Test
	void testRead() throws Exception {
		Menu menu = new Menu(1, "Fish&Chips", "No", 12);
		menu.setId(1L); // menu object to match the one in wood-data.sql
		List<Menu> menus = new ArrayList<>();
		menus.add(menu);
		String responseBody = this.mapper.writeValueAsString(menus);

		this.mockMVC.perform(get("/getMenu")).andExpect(status().isOk()).andExpect(content().json(responseBody));

	}

}
