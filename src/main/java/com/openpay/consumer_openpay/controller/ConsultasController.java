package com.openpay.consumer_openpay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openpay.consumer_openpay.model.BitacoraDto;
import com.openpay.consumer_openpay.model.CharacterDto;
import com.openpay.consumer_openpay.service.ConsultaService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("v1/public")
public class ConsultasController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ConsultasController.class);
	private final String URL_ORIG_ANGULAR="http://localhost:4200";

	@Autowired
	private ConsultaService consultaService;
	
	@CrossOrigin(origins = URL_ORIG_ANGULAR)
	@GetMapping("/characters")
	public ResponseEntity <List<CharacterDto>> characters() {
		
		LOG.info("Consume service v1/public/characters All characters");
		List<CharacterDto> res = consultaService.getAllCharacters();
		
		return ResponseEntity.ok(res);
	}

	@CrossOrigin(origins = URL_ORIG_ANGULAR)
	@GetMapping("/characters/{id}")
	public ResponseEntity<CharacterDto> getMethodName(@PathVariable int id) {

		LOG.info("Consume service v1/public/characters/{id} ONE character");
		CharacterDto res = consultaService.getCharacterByID(id);
		
		return ResponseEntity.ok(res);
	}
	
	@CrossOrigin(origins = URL_ORIG_ANGULAR)
	@GetMapping("/dataBitacora")
	public ResponseEntity <List<BitacoraDto>> getAllBitacora() {
		
		LOG.info("Consume service v1/public/characters All characters");
		List<BitacoraDto> res = consultaService.getAllBitacora();
		
		return ResponseEntity.ok(res);
	}

}
