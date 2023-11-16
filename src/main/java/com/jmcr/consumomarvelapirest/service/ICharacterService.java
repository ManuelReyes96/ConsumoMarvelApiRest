package com.jmcr.consumomarvelapirest.service;

import java.util.List;

import com.jmcr.consumomarvelapirest.entity.Bitacora;
import com.jmcr.consumomarveljar.model.CharacterDataWrapper;

/**
 * Service to consult the Marvel API
 */
public interface ICharacterService {

	/**
	 * Method to get a list of characters
	 * 
	 * @param limit  set the amount of characters
	 * @param offset set the skip number of characters 
	 * @return list of characters
	 */
	CharacterDataWrapper getCharacter(int limit, int offset);
	
	/**
	 * Method for get an specific character
	 * 
	 * @param heroCode identifier of an specific character
	 * @return object of character
	 */
	CharacterDataWrapper getCharacterById(int heroCode);
	
	/**
	 * Method for get the Bitacora
	 * 
	 * @return List of Bitacora
	 */
	List<Bitacora> getLog();
}
