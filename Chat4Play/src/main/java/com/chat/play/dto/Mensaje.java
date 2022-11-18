package com.chat.play.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mensajes")
public class Mensaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_mensaje;
	
	@Column(name = "mensaje")
	private String mensaje;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name="id_party")
    private Party party;
	
	public Mensaje() {
		
	}

	/**
	 * @param id_mensaje
	 * @param mensaje
	 * @param fecha
	 * @param usuario
	 * @param party
	 */
	public Mensaje(Long id_mensaje, String mensaje, Date fecha, Usuario usuario, Party party) {
		//super();
		this.id_mensaje = id_mensaje;
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.usuario = usuario;
		this.party = party;
	}

	
	//Getters y Setters
	
	/**
	 * @return id_mensaje
	 */
	public Long id_mensaje() {
		return id_mensaje;
	}

	/**
	 * @param id_mensaje
	 */
	public void setId(Long id_mensaje) {
		this.id_mensaje = id_mensaje;
	}

	/**
	 * @return mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	/**
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * @return usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * @return party
	 */
	public Party getParty() {
		return party;
	}

	/**
	 * @param party
	 */
	public void setParty(Party party) {
		this.party = party;
	}

	
	//Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Mensaje [id_mensaje=" + id_mensaje + ", mensaje=" + mensaje + ", fecha=" + fecha + ", usuario=" + usuario + ", party=" + party + "]";
	}
}
