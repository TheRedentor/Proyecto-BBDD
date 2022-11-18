package com.chat.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.play.dao.IUsuarioDAO;
import com.chat.play.dto.Usuario;


@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	IUsuarioDAO iUsuarioDAO;

	@Override
	public List<Usuario> listarUsuario() {
		return iUsuarioDAO.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public Usuario usuarioXID(Long id) {
		return iUsuarioDAO.findById(id).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id) {
		iUsuarioDAO.deleteById(id);
	}
}

