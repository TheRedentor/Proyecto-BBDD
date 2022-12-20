package com.chat.play.controller;

import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chat.play.dao.IUsuarioDAO;
import com.chat.play.dto.Usuario;

@RestController
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {
	
	private IUsuarioDAO iUsuarioDAO;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsuarioController(IUsuarioDAO iUsuarioDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.iUsuarioDAO=iUsuarioDAO;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	
	
	
	
	
	
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuario(){
		return iUsuarioDAO.findAll();
	}
	
	
	@PostMapping("/register")
	public Usuario guardarrUsuario(@RequestBody Usuario usuario) {
		usuario.setImg_avatar("../assets/images/avatares/logo_azul.png");
		usuario.setContrasenia(bCryptPasswordEncoder.encode(usuario.getContrasenia()));
		
		return iUsuarioDAO.save(usuario);
	}
	
	
	@GetMapping("/usuario/{id}")
	public Usuario usuarioXID(@PathVariable(name="id") Long id) {
		
		Usuario usuario_xid= new Usuario();
		
		usuario_xid=iUsuarioDAO.findById(id).get();
				
		return usuario_xid;
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario actualizarUsuario(@PathVariable(name="id")Long id,@RequestBody Usuario usuario) {
		
		Usuario usuario_seleccionado= new Usuario();
		Usuario usuario_actualizado= new Usuario();
		
		usuario_seleccionado= iUsuarioDAO.findById(id).get();
		
		usuario_seleccionado.setNombre(usuario.getNombre());
		usuario_seleccionado.setApellidos(usuario.getApellidos());
		usuario_seleccionado.setApodo(usuario.getApodo());
		usuario_seleccionado.setEmail(usuario.getEmail());
		usuario_seleccionado.setContrasenia(bCryptPasswordEncoder.encode(usuario.getContrasenia()));
		usuario_seleccionado.setImg_avatar(usuario.getImg_avatar());

		
		usuario_actualizado = iUsuarioDAO.save(usuario_seleccionado);
				
		return usuario_actualizado;
	}
	
	@PutMapping("/usuario/put2/{id}")
	public Usuario actualizarUsuario2(@PathVariable(name="id")Long id,@RequestBody Usuario usuario) {
		
		Usuario usuario_seleccionado= new Usuario();
		Usuario usuario_actualizado= new Usuario();
		
		usuario_seleccionado= iUsuarioDAO.findById(id).get();
		
		usuario_seleccionado.setNombre(usuario.getNombre());
		usuario_seleccionado.setApellidos(usuario.getApellidos());
		usuario_seleccionado.setApodo(usuario.getApodo());
		usuario_seleccionado.setEmail(usuario.getEmail());
		usuario_seleccionado.setContrasenia(usuario.getContrasenia());
		usuario_seleccionado.setImg_avatar(usuario.getImg_avatar());

		
		usuario_actualizado = iUsuarioDAO.save(usuario_seleccionado);
				
		return usuario_actualizado;
	}
	
	@GetMapping("/usuarios/nombre/{apodo}")
	public Usuario getUsuario(@PathVariable String apodo) {
		return iUsuarioDAO.findByApodo(apodo);
	}
	
	@DeleteMapping("/usuario/{id}")
	public void eliminarUsuario(@PathVariable(name="id")Long id) {
		iUsuarioDAO.deleteById(id);
	}
	
	
}
