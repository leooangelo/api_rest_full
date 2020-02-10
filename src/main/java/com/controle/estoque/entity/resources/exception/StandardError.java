package com.controle.estoque.entity.resources.exception;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
public class StandardError implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone= "GMT")
	@Getter
	@Setter
	
	private Instant timestamp;
	@Getter
	@Setter

	private Integer status;
	@Getter
	@Setter
	private String error;
	
	@Getter
	@Setter
	private String messagem;
	
	@Getter
	@Setter
	private String path;
	
	public StandardError() {}

	public StandardError(Instant timestamp, Integer status, String error, String messagem, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.messagem = messagem;
		this.path = path;
	}

	
	
			
}
