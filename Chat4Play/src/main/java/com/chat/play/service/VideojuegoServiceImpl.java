package com.chat.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.play.dao.IVideojuegoDAO;
import com.chat.play.dto.Videojuego;

@Service
public class VideojuegoServiceImpl implements IVideojuegoService {

	@Autowired
	IVideojuegoDAO iVideojuegoDAO;
	
	
	@Override
	public List<Videojuego> listarVideojuegos() {
		// TODO Auto-generated method stub
		return iVideojuegoDAO.findAll();
	}

	@Override
	public Videojuego guardarVideojuego(Videojuego videojuego) {
		// TODO Auto-generated method stub
		return iVideojuegoDAO.save(videojuego);
	}

	@Override
	public Videojuego videojuego_x_id(Long id) {
		// TODO Auto-generated method stub
		return iVideojuegoDAO.findById(id).get();
	}

	@Override
	public Videojuego actualizarVideojuego(Videojuego videojuego) {
		// TODO Auto-generated method stub
		return iVideojuegoDAO.save(videojuego);
	}

	@Override
	public void eliminarVideojuego(Long id) {
		// TODO Auto-generated method stub
		iVideojuegoDAO.deleteById(id);
		
	}

}
