package com.chat.play.service;

import java.util.List;

import com.chat.play.dto.Mensaje;

public interface IMensajeService {
	public List<Mensaje> listarMensajes();
	
	public Mensaje guardarMensaje(Mensaje mensaje);
	
	public Mensaje mensajeXID(Long id_mensaje);
	
	public Mensaje actualizarMensaje(Mensaje mensaje);
	
	public void eliminarMensaje(Long id_mensaje);
}

