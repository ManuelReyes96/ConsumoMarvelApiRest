package com.jmcr.consumomarvelapirest.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.jmcr.consumomarvelapirest.entity.Bitacora;
import com.jmcr.consumomarvelapirest.service.ICharacterService;
import com.jmcr.consumomarveljar.model.CharacterDataWrapper;

@SpringBootTest
class CharacterControllerTest {

	@InjectMocks
	private CharacterController controller;
	
	@Mock
	private ICharacterService service;
	
	@Test
	void testGetList() {
		CharacterDataWrapper info = new CharacterDataWrapper();
		when(service.getCharacter(0, 0)).thenReturn(info);
		assertDoesNotThrow(() -> controller.getList(0, 0));
	}
	
	@Test
	void testGetCharById() {
		CharacterDataWrapper info = new CharacterDataWrapper();
		when(service.getCharacterById(0)).thenReturn(info);
		assertDoesNotThrow(() -> controller.getCharById(0));
	}
	
	@Test
	void testGetLog() {
		List<Bitacora> info = new ArrayList<>();
		when(service.getLog()).thenReturn(info);
		assertDoesNotThrow(() -> controller.getLog());
	}
}
