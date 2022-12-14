package com.chat.play.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.play.dao.IPartyDAO;
import com.chat.play.dto.Party;

@Service
public class PartyServiceImpl implements IPartyService {

	@Autowired
	IPartyDAO iPartyDAO;
	
	
	@Override
	public List<Party> listarPartys() {
		// TODO Auto-generated method stub
		return iPartyDAO.findAll();
	}

	@Override
	public Party guardarParty(Party party) {
		// TODO Auto-generated method stub
		return iPartyDAO.save(party);
	}

	@Override
	public Party party_x_id(Long id) {
		// TODO Auto-generated method stub
		return iPartyDAO.findById(id).get();
	}

	@Override
	public Party actualizarParty(Party party) {
		// TODO Auto-generated method stub
		return iPartyDAO.save(party);
	}

	@Override
	public void eliminarParty(Long id) {
		// TODO Auto-generated method stub
		iPartyDAO.deleteById(id);
		
	}

	@Override
	public List<Party> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return iPartyDAO.findByNombre(nombre);
	}
}
