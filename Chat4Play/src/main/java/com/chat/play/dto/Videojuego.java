package com.chat.play.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="videojuego")
public class Videojuego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_videojuego;
	
	@Column(name="titulo")
	private String titulo;
	
	public Videojuego() {
		
	}
	
	public Videojuego(String titulo, Long id) {
		this.titulo=titulo;
		this.id_videojuego=id;
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

	@Override
	public String toString() {
		return "Videojuego [id_videojuego=" + id_videojuego + ", titulo=" + titulo + "]";
	}
}
