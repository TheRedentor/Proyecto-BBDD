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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="party")
public class Party {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_party;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToMany
	@JoinColumn(name="id_usuario")
	private List<Usuario> usuario;
	
	@ManyToOne
	@JoinColumn(name="id_videojuego")
	private Videojuego videojuego;
	
	@OneToMany
	@JoinColumn(name="id_mensaje")
	private List<Mensaje> mensaje;
	
	public Party() {
		
	}
	
	public Party(String nombre, Long id, List<Usuario> usuario, Videojuego videojuego, List<Mensaje> mensaje) {
		this.id_party=id;
		this.nombre=nombre;
		this.usuario=usuario;
		this.videojuego=videojuego;
		this.mensaje=mensaje;
	}

	/**
	 * @return the id_party
	 */
	public Long getId_party() {
		return id_party;
	}

	/**
	 * @param id_party the id_party to set
	 */
	public void setId_party(Long id_party) {
		this.id_party = id_party;
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
	 * @return the usuario
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Usuario")
	public List<Usuario> getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the mensaje
	 */
	public List<Mensaje> getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Mensaje")
	public void setMensaje(List<Mensaje> mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the videojuego
	 */
	public Videojuego getVideojuego() {
		return videojuego;
	}

	/**
	 * @param videojuego the videojuego to set
	 */
	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

	@Override
	public String toString() {
		return "Party [id_party=" + id_party + ", nombre=" + nombre + ", videojuego=" + videojuego + "]";
	}
}
