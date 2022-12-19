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
	
	@Column (name="img_avatar")
	private String img_avatar;
	
	@Column (name="apellidos")
	private String apellidos;
	
	@Column (name="apodo", unique=true)
	private String apodo;
	
	@Column (name="email")
	private String email;
	
	@Column (name="contrasenia")
	private String contrasenia;
	
	@ManyToMany(mappedBy = "usuario")
	private List<Party>party;
	
	@Column (name="rol")
	private String rol;
	
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
	 * @param rol
	 */
	public Usuario(String nombre, String apellidos, String apodo, String email, String contrasenia, List<Party> party, String rol) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apodo = apodo;
		this.email = email;
		this.contrasenia = contrasenia;
		this.party = party;
		this.img_avatar = "src/assets/images/avatares/logo_azul";
		this.rol=rol;
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
	


	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
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
	 * @return the party
	 */
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "id_party")
	public List<Party> getParty() {
		return party;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public String getImg_avatar() {
		return img_avatar;
	}


	public void setImg_avatar(String img_avatar) {
		this.img_avatar = img_avatar;
	}


	/**
	 * @param party the party to set
	 */
	public void setParty(List<Party> party) {
		this.party = party;
	}


	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", img_avatar=" + img_avatar
				+ ", apellidos=" + apellidos + ", apodo=" + apodo + ", email=" + email + ", contrasenia=" + contrasenia
				+ ", party=" + party + ", rol=" + rol + "]";
	}

	
}


		