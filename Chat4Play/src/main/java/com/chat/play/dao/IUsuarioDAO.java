package com.chat.play.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.chat.play.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{
	
}
