package com.chat.play.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chat.play.dto.Party;
import com.chat.play.dto.Usuario;

public interface IPartyDAO extends JpaRepository<Party,Long> {
	
	public List<Party> findByNombre(String nombre);
	
	public List<Usuario> usuarioParty(Long id); 

}
