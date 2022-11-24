package com.chat.play.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chat.play.dao.IMensajeDAO;
import com.chat.play.dto.Mensaje;

@Service
public class MensajeServiceImpl implements IMensajeService {
	@Autowired
	IMensajeDAO iMensajeDAO;
	
	@Override
	public List<Mensaje> listarMensajes() {
		
		return iMensajeDAO.findAll();
	}

	@Override
	public Mensaje guardarMensaje(Mensaje mensaje) {
		
		return iMensajeDAO.save(mensaje);
	}

	@Override
	public Mensaje mensajeXID(Long id_mensaje) {
		
		return iMensajeDAO.findById(id_mensaje).get();
	}
	

	@Override
	public Mensaje actualizarMensaje(Mensaje mensaje) {
		
		return iMensajeDAO.save(mensaje);
	}

	@Override
	public void eliminarMensaje(Long id_mensaje) {
		
		iMensajeDAO.deleteById(id_mensaje);
		
	}
}
