package com.jmcr.consumomarvelapirest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumomarvelapirestApplicationTests {

	@Test
	void contextLoads() {
		assertDoesNotThrow(() -> ConsumomarvelapirestApplication.main(new String[] {}));
	}

}
