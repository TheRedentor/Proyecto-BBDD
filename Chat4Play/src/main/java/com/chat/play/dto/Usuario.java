package com.chat.play.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@Column (name="nombre")
	private String nombre;
	
	@Column (name="apellidos")
	private String apellidos;
	
	@Column (name="apodo")
	private String apodo;
	
	@Column (name="email")
	private String email;
	
	@Column (name="contrasenia")
	private String contrasenia;
	
	@ManyToMany(mappedBy = "usuario")
	private List<Party>party;

	
	/**
	 * 
	 */
	public Usuario() {
	}


	/**
	 * @param id_usuario
	 * @param nombre
	 * @param apellidos
	 * @param apodo
	 * @param email
	 * @param contrasenia
	 * @param apodo_steam
	 * @param party
	 */
	public Usuario(Long id_usuario, String nombre, String apellidos, String apodo, String email, String contrasenia, List<Party> party) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apodo = apodo;
		this.email = email;
		this.contrasenia = contrasenia;
		this.party = party;
	}


	/**
	 * @return the id_usuario
	 */
	public Long getId_usuario() {
		return id_usuario;
	}


	/**
	 * @param id_usuario the id_usuario to set
	 */
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}


	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	/**
	 * @return the apodo
	 */
	public String getApodo() {
		return apodo;
	}


	/**
	 * @param apodo the apodo to set
	 */
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}


	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	/**
	 * @return the apodo_steam
	 */
	


	/**
	 * @return the party
	 */
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "id_party")
	public List<Party> getParty() {
		return party;
	}


	/**
	 * @param party the party to set
	 */
	public void setParty(List<Party> party) {
		this.party = party;
	}


	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", apodo="
				+ apodo + ", email=" + email + ", contrasenia=" + contrasenia + ", party=" + party + "]";
	}
}


		