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

import com.chat.play.dto.Rol;
import com.chat.play.service.RolServiceImpl;

@RestController
@RequestMapping("/api")
public class RolController {
	
	@Autowired
	RolServiceImpl rolServiceImpl;
	
	@GetMapping("/roles")
	public List<Rol> listarRoles(){
		return rolServiceImpl.listarRoles();
	}
	
	
	@PostMapping("/roles")
	public Rol salvarRol(@RequestBody Rol rol) {
		
		return rolServiceImpl.guardarRol(rol);
	}
	
	
	@GetMapping("/roles/{id_rol}")
	public Rol rolXID(@PathVariable(name="id_rol") Long id_rol) {
		
		Rol rol_xid = new Rol();
		
		rol_xid = rolServiceImpl.rolXID(id_rol);
		
		System.out.println("Rol XID: " + rol_xid);
		
		return rol_xid;
	}
	
	@PutMapping("/roles/{id_rol}")
	public Rol actualizarRol(@PathVariable(name="id_rol")Long id_rol,@RequestBody  Rol rol) {
		
		Rol rol_seleccionado= new Rol();
		Rol rol_actualizado= new Rol();
		
		rol_seleccionado= rolServiceImpl.rolXID(id_rol);
		
		rol_actualizado = rolServiceImpl.actualizarRol(rol_seleccionado);
		
		System.out.println("El mensaje actualizado es: "+ rol_actualizado);
		
		return rol_actualizado;
	}
	
	@DeleteMapping("/roles/{id_rol}")
	public void eliminarRol(@PathVariable(name="id_rol")Long id_rol) {
		rolServiceImpl.eliminarRol(id_rol);
	}
}
