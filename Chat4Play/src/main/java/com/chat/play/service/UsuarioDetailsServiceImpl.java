package com.chat.play.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

import com.chat.play.dao.IUsuarioDAO;
import com.chat.play.dto.Usuario;
import java.util.List;


@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
	

	private IUsuarioDAO iUsuarioDAO;

	public UsuarioDetailsServiceImpl(IUsuarioDAO iUsuarioDAO) {
		this.iUsuarioDAO = iUsuarioDAO;
	}
	
	public List<Usuario> listarUsuario() {
		return iUsuarioDAO.findAll();
	}

	public Usuario guardarUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	public Usuario usuarioXID(Long id) {
		return iUsuarioDAO.findById(id).get();
	}

	public Usuario actualizarUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	public void eliminarUsuario(Long id) {
		iUsuarioDAO.deleteById(id);
	}

	public Usuario findByUsername(String username) {
		return iUsuarioDAO.findByUsername(username);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = iUsuarioDAO.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getApodo(), usuario.getPassword(), emptyList());
	}
}

