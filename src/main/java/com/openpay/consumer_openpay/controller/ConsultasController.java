package com.openpay.consumer_openpay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openpay.consumer_openpay.model.CharacterDto;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("v1/public")
public class ConsultasController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ConsultasController.class);
	private final String URL_ORIG_ANGULAR="http://localhost:4200";
	   
	//Servicio consulta Lista Clientes
	@CrossOrigin(origins = URL_ORIG_ANGULAR)
	@GetMapping("/characters")
	public ResponseEntity <List<CharacterDto>> characters() {
		
		LOG.info("Consume service get All characters");

		List<CharacterDto> lista = new ArrayList<>();
		
		CharacterDto val = new CharacterDto();
		val.setId(1);
		val.setValor("A");
		lista.add(val);
		
		val = new CharacterDto();
		val.setId(2);
		val.setValor("B");
		lista.add(val);

		val = new CharacterDto();
		val.setId(3);
		val.setValor("*");
		lista.add(val);
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/characters/{id}")
	public ResponseEntity<String> getMethodName(@PathVariable int id) {

		LOG.info("Consume service get characters for Id");
		return ResponseEntity.ok(new String("Service 2 Cliente ID:"+ id));
	}
	

}
