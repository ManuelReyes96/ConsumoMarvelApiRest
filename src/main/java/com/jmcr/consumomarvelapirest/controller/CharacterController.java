package com.jmcr.consumomarvelapirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmcr.consumomarvelapirest.entity.Bitacora;
import com.jmcr.consumomarvelapirest.service.ICharacterService;
import com.jmcr.consumomarveljar.model.CharacterDataWrapper;

/**
 * Controller for receive the request of Front API Rest for consulting Marvel
 * API
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/character")
public class CharacterController {

	/**
	 * Instance of CharacterService
	 */
	@Autowired
	private ICharacterService service;

	/**
	 * GET Method for get the list of characters
	 * 
	 * @param limit  set the amount of characters
	 * @param offset set the skip number of characters
	 * @return json response with list of characters
	 */
	@GetMapping(value = "/list/{limit}/{offset}")
	public ResponseEntity<CharacterDataWrapper> getList(@PathVariable("limit") int limit,
			@PathVariable("offset") int offset) {
		CharacterDataWrapper info = service.getCharacter(limit, offset);
		return new ResponseEntity<>(info, HttpStatus.OK);
	}

	/**
	 * GET Method for get an specific character
	 * 
	 * @param heroCode identifier of an specific character
	 * @return json response with the character
	 */
	@GetMapping(value = "/char/{herocode}")
	public ResponseEntity<CharacterDataWrapper> getCharById(@PathVariable("herocode") int heroCode) {
		CharacterDataWrapper info = service.getCharacterById(heroCode);
		return new ResponseEntity<>(info, HttpStatus.OK);
	}

	/**
	 * GET Method for get the Bitacora
	 * 
	 * @return List of Bitacora
	 */
	@GetMapping(value = "/getlog")
	public ResponseEntity<List<Bitacora>> getLog() {
		List<Bitacora> log = service.getLog();
		return new ResponseEntity<>(log, HttpStatus.OK);
	}
}
