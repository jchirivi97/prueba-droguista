package com.bavaria.prueba.model;

import java.sql.Date;

public class usuario {

	private int identificacion;
	private String tipodocumen;
	private String establecimiento;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private String email;
	private String departamento;
	private String ciudad;
	private String direccion;
	private int estrato;
	private Date fecha;
	private boolean terminos;
	private boolean informacion;

	public usuario() {

	}

	public usuario(int identificacion, String tipodocumen, String establecimiento, String nombre1, String nombre2,
			String apellido1, String apellido2, String email,String departamento,String ciudad,String direccion,int estrato,boolean terminos,boolean informacion,Date fecha) {
		this.identificacion =identificacion;
		this.tipodocumen = tipodocumen;
		this.establecimiento = establecimiento;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.email = email;
		this.departamento = departamento;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.estrato = estrato;
		this.terminos = terminos;
		this.informacion = informacion;
		this.fecha = fecha;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public String getTipodocumen() {
		return tipodocumen;
	}

	public void setTipodocumen(String tipodocumen) {
		this.tipodocumen = tipodocumen;
	}

	public String getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEstrato() {
		return estrato;
	}

	public void setEstrato(int estrato) {
		this.estrato = estrato;
	}

	public boolean isTerminos() {
		return terminos;
	}

	public void setTerminos(boolean terminos) {
		this.terminos = terminos;
	}

	public boolean isInformacion() {
		return informacion;
	}

	public void setInformacion(boolean informacion) {
		this.informacion = informacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
