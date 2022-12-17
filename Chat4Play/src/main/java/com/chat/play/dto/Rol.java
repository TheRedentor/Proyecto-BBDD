package com.chat.play.dto;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="roles")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_rol;
	
	@Column(name="rol")
	private String rol;
	
	
	
	public Rol() {
		
	}

	/**
	 * @param id_rol
	 */
	public Rol(Long id_rol,String rol) {
		//super();
		this.id_rol = id_rol;
		this.rol=rol;
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
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
