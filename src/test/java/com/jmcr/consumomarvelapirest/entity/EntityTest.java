package com.jmcr.consumomarvelapirest.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EntityTest {

	private Bitacora bitacora;

	@Test
	void testEntity() {
		bitacora = new Bitacora(0, "serviceName", LocalDateTime.now());

		assertEquals(0, bitacora.getId());
		assertNotNull(bitacora.getServiceName());
		assertNotNull(bitacora.getTimestamp());
	}
}
