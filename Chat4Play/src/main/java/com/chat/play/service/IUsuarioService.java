package com.chat.play.service;

import java.util.List;

import com.chat.play.dto.Usuario;

public interface IUsuarioService {

	
		public List<Usuario> listarUsuario();
		
		public Usuario guardarUsuario(Usuario usuario);
		
		public Usuario usuarioXID(Long id); 
		
		public Usuario actualizarUsuario(Usuario usuario); 
		
		public void eliminarUsuario(Long id);
	
		public Usuario findByNombre(String nombre);

}


