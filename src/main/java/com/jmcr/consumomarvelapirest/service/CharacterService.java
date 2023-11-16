package com.jmcr.consumomarvelapirest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jmcr.consumomarvelapirest.entity.Bitacora;
import com.jmcr.consumomarvelapirest.repository.IBitacoraRepository;
import com.jmcr.consumomarveljar.apiconnect.ApiMarvelConnection;
import com.jmcr.consumomarveljar.model.CharacterDataWrapper;

/**
 * Service to consult the Marvel API
 */
@Service
public class CharacterService implements ICharacterService {

	/**
	 * Instance of ApiMarvelConnection to connect to Marvel API
	 */
	private ApiMarvelConnection apiMarvelConnection = new ApiMarvelConnection();

	/**
	 * Instance of Bitacora Repository
	 */
	@Autowired
	private IBitacoraRepository bitacoraRepository;

	/**
	 * Method to get a list of characters
	 * 
	 * @param limit  set the amount of characters
	 * @param offset set the skip number of characters 
	 * @return list of characters
	 */
	@Override
	public CharacterDataWrapper getCharacter(int limit, int offset) {
		addNewBitacora("getCharacter");
		return apiMarvelConnection.getCharacters(limit, offset);
	}

	/**
	 * Method for get an specific character
	 * 
	 * @param heroCode identifier of an specific character
	 * @return object of character
	 */
	@Override
	public CharacterDataWrapper getCharacterById(int heroCode) {
		addNewBitacora("getCharacterById");
		return apiMarvelConnection.getCharacterById(heroCode);
	}

	/**
	 * Method for get the Bitacora
	 * 
	 * @return List of Bitacora
	 */
	@Override
	public List<Bitacora> getLog() {
		return bitacoraRepository.findAll(Sort.by(Sort.Direction.DESC, "timestamp"));
	}

	/**
	 * Method for save a record of Bitacora
	 * @param nameService name of service
	 */
	private void addNewBitacora(String nameService) {
		var bitacora = new Bitacora();
		bitacora.setServiceName(nameService);
		bitacora.setTimestamp(LocalDateTime.now());
		bitacoraRepository.save(bitacora);
	}

}
