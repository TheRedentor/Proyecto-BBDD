package com.chat.play.service;

import java.util.List;

import com.chat.play.dto.Videojuego;

public interface IVideojuegoService {
	public List<Videojuego> listarVideojuegos();
	
	public Videojuego guardarVideojuego(Videojuego videojuego);
	
	public Videojuego videojuego_x_id(Long id);
	
	public Videojuego actualizarVideojuego(Videojuego videojuego);
	
	public void eliminarVideojuego(Long id);
}
