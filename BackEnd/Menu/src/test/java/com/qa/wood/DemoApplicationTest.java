package com.qa.wood;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.wood.domain.Wood;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
public class DemoApplicationTest {
	@Test
	void contextLoads() {
	}

	@Test //Smokes test
	void giveCoverage() {
		EqualsVerifier.forClass(Wood.class).usingGetClass().verify();
	}​ ​

}
