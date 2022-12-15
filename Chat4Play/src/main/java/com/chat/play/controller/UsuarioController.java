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

import com.chat.play.dto.Usuario;
import com.chat.play.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuario(){
		return usuarioServiceImpl.listarUsuario();
	}
	
	
	@PostMapping("/usuario")
	public Usuario guardarrUsuario(@RequestBody Usuario usuario) {
		
		usuario.setImg_avatar("../assets/images/avatar2.png");
		
		return usuarioServiceImpl.guardarUsuario(usuario);
	}
	
	
	@GetMapping("/usuario/{id}")
	public Usuario usuarioXID(@PathVariable(name="id") Long id) {
		
		Usuario usuario_xid= new Usuario();
		
		usuario_xid=usuarioServiceImpl.usuarioXID(id);
				
		return usuario_xid;
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario actualizarUsuario(@PathVariable(name="id")Long id,@RequestBody Usuario usuario) {
		
		Usuario usuario_seleccionado= new Usuario();
		Usuario usuario_actualizado= new Usuario();
		
		usuario_seleccionado= usuarioServiceImpl.usuarioXID(id);
		
		usuario_seleccionado.setNombre(usuario.getNombre());
		usuario_seleccionado.setApellidos(usuario.getApellidos());
		usuario_seleccionado.setApodo(usuario.getApodo());
		usuario_seleccionado.setEmail(usuario.getEmail());
		usuario_seleccionado.setContrasenia(usuario.getContrasenia());
		usuario_seleccionado.setImg_avatar(usuario.getImg_avatar());

		
		usuario_actualizado = usuarioServiceImpl.actualizarUsuario(usuario_seleccionado);
				
		return usuario_actualizado;
	}
	
	@DeleteMapping("/usuario/{id}")
	public void eliminarUsuario(@PathVariable(name="id")Long id) {
		usuarioServiceImpl.eliminarUsuario(id);
	}
	
	
}
