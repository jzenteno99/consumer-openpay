package com.openpay.consumer_openpay.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.openpay.consumer_openpay.model.BitacoraDto;
import com.openpay.consumer_openpay.model.CharacterDto;


@Service
public class ConsultaServiceImpl implements ConsultaService{

	private final String URL_All_CHARS = "http://localhost:8082/marvel/services/getAllCharacters";
	private final String URL_ONE_CHAR = "http://localhost:8082/marvel/services/getCharacterById/";
	private final String URL_All_BITACORA = "http://localhost:8082/marvel/services/getAllBitacoras";

	@Value("${procesos.service.user}")
	private String user;

	@Value("${procesos.service.password}")
	private String password;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CharacterDto> getAllCharacters() {

		List<CharacterDto> res = new ArrayList<>();
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(user, password));
			ResponseEntity<List<CharacterDto>> responseEntity = restTemplate
					.exchange(URL_All_CHARS,HttpMethod.GET, null, 
							new ParameterizedTypeReference<List<CharacterDto>>(){});
			
			res = responseEntity.getBody();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public CharacterDto getCharacterByID(Integer id) {

		CharacterDto res = new CharacterDto();
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(user, password));
			ResponseEntity<CharacterDto> responseEntity = restTemplate
					.exchange(URL_ONE_CHAR + id.toString(),HttpMethod.GET, null, CharacterDto.class);
			
			res = responseEntity.getBody();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	HttpHeaders createHeaders(String username, String password){
		   return new HttpHeaders() {
			   
			private static final long serialVersionUID = 1L;

		{
		         String auth = username + ":" + password;
		         byte[] encodedAuth = Base64.encodeBase64( 
		            auth.getBytes(Charset.forName("US-ASCII")) );
		         String authHeader = "Basic " + new String( encodedAuth );
		         set( "Authorization", authHeader );
		      }};
		}

	@Override
	public List<BitacoraDto> getAllBitacora() {

		List<BitacoraDto> res = new ArrayList<>();
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(user, password));
			ResponseEntity<List<BitacoraDto>> responseEntity = restTemplate
					.exchange(URL_All_BITACORA,HttpMethod.GET, null, 
							new ParameterizedTypeReference<List<BitacoraDto>>(){});
			
			res = responseEntity.getBody();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
