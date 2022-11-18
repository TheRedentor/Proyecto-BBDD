package com.chat.play.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.play.dto.Mensaje;
import com.chat.play.service.MensajeServiceImpl;

@RestController
@RequestMapping("/api")
public class MensajeController {
	@Autowired
	MensajeServiceImpl mensajeServiceImpl;
	
	@GetMapping("/mensajes")
	public List<Mensaje> listarMensajes(){
		return mensajeServiceImpl.listarMensajes();
	}
	
	
	@PostMapping("/mensajes")
	public Mensaje salvarMensaje(Mensaje mensaje) {
		
		return mensajeServiceImpl.guardarMensaje(mensaje);
	}
	
	
	@GetMapping("/mensajes/{id_mensaje}")
	public Mensaje mensajeXID(@PathVariable(name="id_mensaje") Long id_mensaje) {
		
		Mensaje mensaje_xid = new Mensaje();
		
		mensaje_xid = mensajeServiceImpl.mensajeXID(id_mensaje);
		
		System.out.println("Mensaje XID: " + mensaje_xid);
		
		return mensaje_xid;
	}
	
	@PutMapping("/mensajes/{id_mensaje}")
	public Mensaje actualizarMensaje(@PathVariable(name="id_mensaje")Long id_mensaje, Mensaje mensaje) {
		
		Mensaje mensaje_seleccionado= new Mensaje();
		Mensaje mensaje_actualizado= new Mensaje();
		
		mensaje_seleccionado= mensajeServiceImpl.mensajeXID(id_mensaje);
		
		mensaje_seleccionado.setMensaje(mensaje.getMensaje());
		mensaje_seleccionado.setFecha(mensaje.getFecha());
		mensaje_seleccionado.setUsuario(mensaje.getUsuario());
		mensaje_seleccionado.setParty(mensaje.getParty());
		
		mensaje_actualizado = mensajeServiceImpl.actualizarMensaje(mensaje_seleccionado);
		
		System.out.println("El mensaje actualizado es: "+ mensaje_actualizado);
		
		return mensaje_actualizado;
	}
	
	@DeleteMapping("/mensajes/{id_mensaje}")
	public void eliminarMensaje(@PathVariable(name="id_mensaje")Long id_mensaje) {
		mensajeServiceImpl.eliminarMensaje(id_mensaje);
	}
}
