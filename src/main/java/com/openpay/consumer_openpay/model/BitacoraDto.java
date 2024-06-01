package com.openpay.consumer_openpay.model;

import java.util.Date;

import lombok.Data;

@Data
public class BitacoraDto {

	private Long id;
	private String nameService;
	private Date fechaOpera;
	
	public Long getId() {
		return id;
	}
	public String getNameService() {
		return nameService;
	}
	public Date getFechaOpera() {
		return fechaOpera;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNameService(String nameService) {
		this.nameService = nameService;
	}
	public void setFechaOpera(Date fechaOpera) {
		this.fechaOpera = fechaOpera;
	}
	
}
