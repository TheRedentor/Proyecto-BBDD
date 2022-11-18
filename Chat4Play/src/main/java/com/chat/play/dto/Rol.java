package com.chat.play.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="roles")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_rol;
	
	public Rol() {
		
	}

	/**
	 * @param id_rol
	 */
	public Rol(Long id_rol) {
		//super();
		this.id_rol = id_rol;
	}

	
	//Getters y Setters
	
	/**
	 * @return id_rol
	 */
	public Long id_rol() {
		return id_rol;
	}

	/**
	 * @param id_rol
	 */
	public void setId(Long id_rol) {
		this.id_rol = id_rol;
	}

	
	//Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Rol [id_rol=" + id_rol + "]";
	}
}
