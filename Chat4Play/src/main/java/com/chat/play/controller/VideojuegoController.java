package com.chat.play.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.play.dto.Videojuego;
import com.chat.play.service.VideojuegoServiceImpl;


@RestController
@RequestMapping("/api")
public class VideojuegoController {
	
	@Autowired
	VideojuegoServiceImpl videojuegoServiceImpl;
	
	@GetMapping("/videojuego")
	public List<Videojuego> listarVideojuegos(){
		return videojuegoServiceImpl.listarVideojuegos();
	}
	
	@PostMapping("/videojuego")
	public Videojuego salvarVideojuego(@RequestBody Videojuego videojuego) {
		
		return videojuegoServiceImpl.guardarVideojuego(videojuego);
	}
	
	@GetMapping("/videojuego/{id_videojuego}")
	public Videojuego videojuego_x_ID(@PathVariable(name="id_videojuego") Long id) {
		
		Videojuego videojuego_x_id= new Videojuego();
		
		videojuego_x_id=videojuegoServiceImpl.videojuego_x_id(id);
		
		System.out.println("Videojuego XID: "+videojuego_x_id);
		
		return videojuego_x_id;
	}
	
	@PutMapping("/videojuego/{id_videojuego}")
	public Videojuego actualizarVideojuego(@PathVariable(name="id_videojuego")Long id,@RequestBody Videojuego videojuego) {
		
		Videojuego videojuego_seleccionado= new Videojuego();
		Videojuego videojuego_actualizado= new Videojuego();
		
		videojuego_seleccionado= videojuegoServiceImpl.videojuego_x_id(id);
		
		videojuego_seleccionado.setTitulo(videojuego.getTitulo());
		videojuego_seleccionado.setId_videojuego(videojuego.getId_videojuego());
		
		videojuego_actualizado = videojuegoServiceImpl.actualizarVideojuego(videojuego_seleccionado);
		
		System.out.println("El videojuego actualizado es: "+ videojuego_actualizado);
		
		return videojuego_actualizado;
	}
	
	@DeleteMapping("/videojuego/{id_videojuego}")
	public void eliminarArticulo(@PathVariable(name="id_videojuego")Long id) {
		videojuegoServiceImpl.eliminarVideojuego(id);
	}
	
	
}