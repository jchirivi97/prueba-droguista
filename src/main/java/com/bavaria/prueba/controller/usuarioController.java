package com.bavaria.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bavaria.prueba.model.usuario;
import com.bavaria.prueba.service.usuarioServices;

@RestController
@RequestMapping(value="/usuario")
public class usuarioController {
	
	@Autowired
	usuarioServices usuarioServ;

	/**
	 * Mediante el mapeo de la url '/usuario/all' se solicita todos los usuarios registrados
	 * @return una lista de usuarios en formato JSON
	 */
	@RequestMapping(method = RequestMethod.GET,path="/all")
	public ResponseEntity<List<usuario>> getallUsers(){
		return ResponseEntity.ok(usuarioServ.getAllUsers());
	} 
	
	/**
	 * Mediante el mapeo de la url '/usuario/{email}' se solicita informacion del usuario especifico
	 * @param email
	 * @return la informacion del usuario en formato JSON
	 */
	@RequestMapping(method = RequestMethod.GET,path="/{email}")
	public ResponseEntity<usuario> getUser(@PathVariable("email") String email){
		return ResponseEntity.ok(usuarioServ.getUser(email));
	}
	
	/**
	 * Almacena la informacion de un nuevo usuario
	 * @param user(tipo JSON)
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveUser(@RequestBody usuario user) {
		usuarioServ.saveUser(user.getIdentificacion(), user.getTipodocumen(), user.getEstablecimiento(), user.getNombre1(), user.getNombre2(), user.getApellido1(), user.getApellido2(), user.getEmail(), user.getDepartamento(), user.getCiudad(), user.getDireccion(),user.getEstrato(), user.isTerminos(), user.isInformacion(),user.getFecha());
	}
	
	
	/**
	 * Actualiza informacion del usuario
	 * @param user
	 */
	@RequestMapping(method = RequestMethod.PUT,path="/update")
	public void updateUser(@RequestBody usuario user) {
		usuarioServ.updateUser(user.getEmail(),user.getEstablecimiento(), user.getNombre1(), user.getNombre2(), user.getApellido1(), user.getApellido2(), user.getDepartamento(), user.getCiudad(), user.getDireccion(), user.getEstrato());
	}
	

}
