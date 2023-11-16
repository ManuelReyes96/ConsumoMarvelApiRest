package com.jmcr.consumomarvelapirest.service;

import java.util.List;

import com.jmcr.consumomarvelapirest.entity.Bitacora;
import com.jmcr.consumomarveljar.model.CharacterDataWrapper;

public interface IGetCharacterService {

	CharacterDataWrapper getCharacter(int limit, int offset);
	
	CharacterDataWrapper getCharacterById(int heroCode);
	
	List<Bitacora> getLog();
}
