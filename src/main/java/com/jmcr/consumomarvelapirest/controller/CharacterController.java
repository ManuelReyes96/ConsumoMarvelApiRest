package com.jmcr.consumomarvelapirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmcr.consumomarvelapirest.entity.Bitacora;
import com.jmcr.consumomarvelapirest.service.IGetCharacterService;
import com.jmcr.consumomarveljar.model.CharacterDataWrapper;

@RestController
@RequestMapping("/character")
public class CharacterController {

	@Autowired
	private IGetCharacterService service;
	
	@GetMapping(value = "/list/{limit}/{offset}")
	public ResponseEntity<CharacterDataWrapper> getList(@PathVariable("limit") int limit, @PathVariable("offset") int offset){
		CharacterDataWrapper info = service.getCharacter(limit, offset);
		System.out.println(info);
		return new ResponseEntity<>(info, HttpStatus.OK);
	}
	
	@GetMapping(value = "/char/{herocode}")
	public ResponseEntity<CharacterDataWrapper> getCharById(@PathVariable("herocode") int heroCode){
		CharacterDataWrapper info = service.getCharacterById(heroCode);
		System.out.println(info);
		return new ResponseEntity<>(info, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getlog")
	public ResponseEntity<List<Bitacora>> getLog(){
		List<Bitacora> log = service.getLog();
		return new ResponseEntity<List<Bitacora>>(log, HttpStatus.OK);
	}
}
