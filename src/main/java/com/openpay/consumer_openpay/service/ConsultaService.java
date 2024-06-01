package com.openpay.consumer_openpay.service;

import java.util.List;

import com.openpay.consumer_openpay.model.BitacoraDto;
import com.openpay.consumer_openpay.model.CharacterDto;

public interface ConsultaService {

	public List<CharacterDto> getAllCharacters();
	
	public CharacterDto getCharacterByID(Integer id);
	
	public List<BitacoraDto> getAllBitacora();
	
}
