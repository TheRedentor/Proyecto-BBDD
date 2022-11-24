package com.chat.play.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chat.play.dao.IRolDAO;
import com.chat.play.dto.Rol;

@Service
public class RolServiceImpl implements IRolService {
	@Autowired
	IRolDAO iRolDAO;
	
	@Override
	public List<Rol> listarRoles() {
		
		return iRolDAO.findAll();
	}

	@Override
	public Rol guardarRol(Rol rol) {
		
		return iRolDAO.save(rol);
	}

	@Override
	public Rol rolXID(Long id_rol) {
		
		return iRolDAO.findById(id_rol).get();
	}
	

	@Override
	public Rol actualizarRol(Rol rol) {
		
		return iRolDAO.save(rol);
	}

	@Override
	public void eliminarRol(Long id_rol) {
		
		iRolDAO.deleteById(id_rol);
		
	}
}
