package com.chat.play.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chat.play.dto.Videojuego;

public interface IVideojuegoDAO extends JpaRepository<Videojuego,Long> {

}