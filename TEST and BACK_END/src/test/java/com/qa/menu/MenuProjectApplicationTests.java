package com.qa.menu;

import java.awt.Menu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
class MenuProjectApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Test
	void giveCoverage() {
		EqualsVerifier.forClass(Menu.class).usingGetClass().verify();
	}

}
