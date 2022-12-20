package com.chat.play.service;

import java.util.List;

import com.chat.play.dto.Party;
import com.chat.play.dto.Usuario;

public interface IPartyService {
	public List<Party> listarPartys();
	
	public Party guardarParty(Party Party);
	
	public Party party_x_id(Long id);
	
	public Party actualizarParty(Party party);
	
	public void eliminarParty(Long id);
	
	public List<Party> findByNombre(String nombre);
	
	public List<Usuario> usuariosParty(Long id);
	
}
