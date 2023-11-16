package com.jmcr.consumomarvelapirest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmcr.consumomarvelapirest.entity.Bitacora;
import com.jmcr.consumomarvelapirest.repository.IBitacoraRepository;
import com.jmcr.consumomarveljar.apiconnect.ApiMarvelConnection;
import com.jmcr.consumomarveljar.model.CharacterDataWrapper;

@Service
public class GetCharacterService implements IGetCharacterService {
	
	private ApiMarvelConnection apiMarvelConnection = new ApiMarvelConnection();
	
	@Autowired
	private IBitacoraRepository bitacoraRepository;

	@Override
	public CharacterDataWrapper getCharacter(int limit, int offset) {
		addNewBitacora("getCharacter");
		return apiMarvelConnection.getCharacters(limit, offset);
	}

	@Override
	public CharacterDataWrapper getCharacterById(int heroCode) {
		addNewBitacora("getCharacterById");
		return apiMarvelConnection.getCharacterById(heroCode);
	}

	@Override
	public List<Bitacora> getLog() {
		return bitacoraRepository.findAll();
	}
	
	private void addNewBitacora(String nameService) {
		Bitacora bitacora = new Bitacora();
		bitacora.setServiceName(nameService);
		bitacora.setTimestamp(LocalDateTime.now());
		bitacoraRepository.save(bitacora);
	}

}
