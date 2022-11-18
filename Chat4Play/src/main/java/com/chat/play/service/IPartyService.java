package com.chat.play.service;

import java.util.List;

import com.chat.play.dto.Party;

public interface IPartyService {
	public List<Party> listarPartys();
	
	public Party guardarParty(Party Party);
	
	public Party party_x_id(Long id);
	
	public Party actualizarParty(Party party);
	
	public void eliminarParty(Long id);
}
