package com.chat.play.dto;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="videojuego")
public class Videojuego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_videojuego;
	
	@Column(name="titulo")
	private String titulo;
	
	@OneToMany
	@JoinColumn(name="id_videojuego")
	private List<Party> party;
	
	public Videojuego() {
		
	}
	
	public Videojuego(String titulo, Long id, List<Party> party) {
		this.titulo=titulo;
		this.id_videojuego=id;
		this.party=party;
	}

	public Long getId_videojuego() {
		return id_videojuego;
	}

	public void setId_videojuego(Long id_videojuego) {
		this.id_videojuego = id_videojuego;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "party")
	public List<Party> getParty() {
		return party;
	}

	public void setParty(List<Party> party) {
		this.party = party;
	}

	@Override
	public String toString() {
		return "Videojuego [id_videojuego=" + id_videojuego + ", titulo=" + titulo + "]";
	}
}
