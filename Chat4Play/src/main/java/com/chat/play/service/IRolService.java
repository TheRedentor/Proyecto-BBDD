package com.chat.play.service;

import java.util.List;

import com.chat.play.dto.Rol;

public interface IRolService {
	public List<Rol> listarRoles();
	
	public Rol guardarRol(Rol rol);
	
	public Rol rolXID(Long id_rol);
	
	public Rol actualizarRol(Rol rol);
	
	public void eliminarRol(Long id_rol);
}

