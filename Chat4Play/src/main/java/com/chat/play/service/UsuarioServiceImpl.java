package com.chat.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.chat.play.dao.IUsuarioDAO;
import com.chat.play.dto.Usuario;
import static java.util.Collections.emptyList;


@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	IUsuarioDAO iUsuarioDAO;

	public UsuarioServiceImpl(IUsuarioDAO IUsuarioDAO) {
		this.iUsuarioDAO=IUsuarioDAO;
	}
	
	@Override
	public List<Usuario> listarUsuario() {
		return iUsuarioDAO.findAll();
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Usuario usuario = iUsuarioDAO.findByNombre(username);
		if(usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getNombre(),usuario.getContrasenia(), emptyList());
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

	@Override
	public Usuario findByNombre(String nombre) {
		return iUsuarioDAO.findByNombre(nombre);
		
	}
}

