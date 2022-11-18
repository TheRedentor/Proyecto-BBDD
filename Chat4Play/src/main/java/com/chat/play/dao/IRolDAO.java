package com.chat.play.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chat.play.dto.Rol;

public interface IRolDAO extends JpaRepository<Rol, Long>{

}