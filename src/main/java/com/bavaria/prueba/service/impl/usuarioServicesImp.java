package com.bavaria.prueba.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bavaria.prueba.model.usuario;
import com.bavaria.prueba.persistence.usuarioPersistence;
import com.bavaria.prueba.service.usuarioServices;

@Service
public class usuarioServicesImp implements usuarioServices{
	
	
	usuarioPersistence usuarioPer;
	
	/**
	 * Crear una conexion a la base de datos para enviar la peticion
	 */
	private void getConnection() {
		usuarioPer = new usuarioPersistence();
	}

	/**
	 * Solicita la informacion de todos los usuarios registrados
	 * @param none
	 * @return retorna una lista de todos los usuarios registrados
	 */
	@Override
	public List<usuario> getAllUsers() {
		getConnection();
		return usuarioPer.getAllUsers();
	}

	/**
	 * Solicita la informacion de un usuario en especifico
	 * @param email del usuario
	 * @return retorna informacion del usuario consultado
	 */
	@Override
	public usuario getUser(String email) {
		getConnection();
		return usuarioPer.getUser(email);
	}

	/**
	 *Guarda la informacion del cliente
	 *@param informacion del cliente 
	 */
	@Override
	public void saveUser(int identificacion, String tipodocumen, String establecimiento, String nombre1, String nombre2,
			String apellido1, String apellido2, String email, String departamento, String ciudad, String direccion,
			int estrato, boolean terminos, boolean informacion,Date fecha) {
		getConnection();
		usuarioPer.saveUser(identificacion, tipodocumen, establecimiento, nombre1, nombre2, apellido1, apellido2, email, departamento, ciudad, direccion, estrato, terminos, informacion,fecha);
		
	}

	/**
	 * Actualiza la informacion del usuario 
	 * @param datos a actulizar del usuario
	 */
	@Override
	public void updateUser(String email,String establecimiento, String nombre1, String nombre2, String apellido1, String apellido2,
			String departamento, String ciudad, String direccion, int estrato) {
		getConnection();
		usuarioPer.updateUser(email,establecimiento, nombre1, nombre2, apellido1, apellido2, departamento, ciudad, direccion, estrato);
	}

}
