package com.jmcr.consumomarvelapirest.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.jmcr.consumomarvelapirest.entity.Bitacora;
import com.jmcr.consumomarvelapirest.repository.IBitacoraRepository;
import com.jmcr.consumomarveljar.apiconnect.ApiMarvelConnection;
import com.jmcr.consumomarveljar.model.CharacterDataWrapper;

@SpringBootTest
class CharacterServiceTest {

	@InjectMocks
	private CharacterService service;
	
	@Mock
	private ApiMarvelConnection connection;
	
	@Mock
	private IBitacoraRepository repository;
	
	@Test
	void testGetCharacter() {
		CharacterDataWrapper info = new CharacterDataWrapper();
		when(connection.getCharacters(0, 0)).thenReturn(info);
		assertDoesNotThrow(() -> service.getCharacter(0, 0));
	}
	
	@Test
	void testGetCharacterById() {
		CharacterDataWrapper info = new CharacterDataWrapper();
		when(connection.getCharacterById(0)).thenReturn(info);
		assertDoesNotThrow(() -> service.getCharacterById(0));
	}
	
	@Test
	void testGetLog() {
		Bitacora info = new Bitacora();
		when(repository.save(any())).thenReturn(info);
		assertDoesNotThrow(() -> service.getLog());
	}
}
