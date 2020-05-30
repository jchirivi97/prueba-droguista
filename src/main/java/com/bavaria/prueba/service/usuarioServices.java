package com.bavaria.prueba.service;

import java.sql.Date;
import java.util.List;

import com.bavaria.prueba.model.usuario;

public interface usuarioServices {

	List<usuario> getAllUsers();

	usuario getUser(String email);

	void saveUser(int identificacion, String tipodocumen, String establecimiento, String nombre1, String nombre2,
			String apellido1, String apellido2, String email, String departamento, String ciudad, String direccion,
			int estrato, boolean terminos, boolean informacion,Date fecha);

	void updateUser(String establecimiento, String nombre1, String nombre2, String apellido1, String apellido2,
			String departamento, String ciudad, String direccion, int estrato);
	
	

}
