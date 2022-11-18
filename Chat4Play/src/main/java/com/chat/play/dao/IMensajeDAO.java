package com.chat.play.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chat.play.dto.Mensaje;

public interface IMensajeDAO extends JpaRepository<Mensaje, Long>{

}