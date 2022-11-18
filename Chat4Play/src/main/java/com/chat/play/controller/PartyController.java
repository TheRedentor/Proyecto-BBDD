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

import com.chat.play.dto.Party;
import com.chat.play.service.PartyServiceImpl;

@RestController
@RequestMapping("/api")
public class PartyController {
	
	@Autowired
	PartyServiceImpl partyServiceImpl;
	
	@GetMapping("/party")
	public List<Party> listarPartys(){
		return partyServiceImpl.listarPartys();
	}
	
	@PostMapping("/party")
	public Party salvarParty(@RequestBody Party party) {
		
		return partyServiceImpl.guardarParty(party);
	}
	
	@GetMapping("/party/{id_party}")
	public Party party_x_ID(@PathVariable(name="id_party") Long id) {
		
		Party party_x_id= new Party();
		
		party_x_id=partyServiceImpl.party_x_id(id);
		
		System.out.println("Party XID: "+party_x_id);
		
		return party_x_id;
	}
	
	@PutMapping("/party/{id_party}")
	public Party actualizarParty(@PathVariable(name="id_party")Long id,@RequestBody Party party) {
		
		Party party_seleccionado= new Party();
		Party party_actualizado= new Party();
		
		party_seleccionado= partyServiceImpl.party_x_id(id);
		
		party_seleccionado.setId_party(party.getId_party());
		party_seleccionado.setNombre(party.getNombre());
		party_seleccionado.setVideojuego(party.getVideojuego());
		
		party_actualizado = partyServiceImpl.actualizarParty(party_seleccionado);
		
		System.out.println("El party actualizado es: "+ party_actualizado);
		
		return party_actualizado;
	}
	
	@DeleteMapping("/party/{id_party}")
	public void eliminarParty(@PathVariable(name="id_party")Long id) {
		partyServiceImpl.eliminarParty(id);
	}
	
	
}