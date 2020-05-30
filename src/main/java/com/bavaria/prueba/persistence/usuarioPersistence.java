package com.bavaria.prueba.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bavaria.prueba.model.usuario;



public class usuarioPersistence {
	
	
	/// url de conexion a la base de datos
	
	private static final String url = "jdbc:postgresql://ec2-34-206-252-187.compute-1.amazonaws.com/dcm9mm4j1mh25e?user=aeuadtvkkjhcyx&password=dae78d3e8faa1b0b4a35a0539605d2ceb0b415aaa44ebc18be0b64519d6e5683";
	
	private Connection con;
	
	private usuario user;
	
	
	public void getConection() {
		try {
			
			con = DriverManager.getConnection(url);
						
		}catch(SQLException e) {
			e.getMessage();			
		}
	}
	
	/**
	 * Solicita la informacion de todos los usuarios registrados
	 * @param none
	 * @return retorna una lista de todos los usuarios registrados
	 */
	public List<usuario> getAllUsers (){
		PreparedStatement pstmt = null;
		List<usuario> users = new ArrayList<usuario>();
		try {
			Class.forName("org.postgresql.Driver");
			getConection();
			con.setAutoCommit(false);
			String consult = "select * from usuario";
			pstmt = con.prepareStatement(consult, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			con.close();
			while(rs.next()) {
				user = new usuario(rs.getInt("identificacion"),rs.getString("tipodocum"),rs.getString("establecimiento"),rs.getString("nombre1"),rs.getString("nombre2"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("email"),rs.getString("departamento"),rs.getString("ciudad"),rs.getString("direccion"),rs.getInt("estrato"),rs.getBoolean("terminos"),rs.getBoolean("informacion"),rs.getDate("fecha"));
				users.add(user);
			}
			pstmt.close();
			rs.close();
			return users;
		}
		catch(Exception e) {
			Logger.getLogger(usuarioPersistence.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		
	}
	
	/**
	 * Solicita la informacion de un usuario en especifico
	 * @param email del usuario
	 * @return retorna informacion del usuario consultado
	 */
	public usuario getUser (String email){
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			getConection();
			con.setAutoCommit(false);
			String consult = "select * from usuario where email = ?";
			pstmt = con.prepareStatement(consult, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			con.close();
			if(rs.next()) {
				user = new usuario(rs.getInt("identificacion"),rs.getString("tipodocum"),rs.getString("establecimiento"),rs.getString("nombre1"),rs.getString("nombre2"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("email"),rs.getString("departamento"),rs.getString("ciudad"),rs.getString("direccion"),rs.getInt("estrato"),rs.getBoolean("terminos"),rs.getBoolean("informacion"),rs.getDate("fecha"));
			}
			pstmt.close();
			rs.close();
			return user;
		}
		catch(Exception e) {
			Logger.getLogger(usuarioPersistence.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		
	}
	
	/**
	 *Guarda la informacion del cliente
	 *@param informacion del cliente 
	 */
	public void saveUser (int identificacion, String tipodocumen, String establecimiento, String nombre1, String nombre2,
			String apellido1, String apellido2, String email,String departamento,String ciudad,String direccion,int estrato,boolean terminos,boolean informacion,Date fecha) {
		Statement stmt = null;
		try {
			
			Class.forName("org.postgresql.Driver");
			getConection();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			String consult = "insert into usuario (identificacion,tipodocum,establecimiento,nombre1,nombre2,apellido1,apellido2,email,departamento,ciudad,direccion,estrato,terminos,informacion,fecha)"
				+"values ('" + identificacion +"','"+tipodocumen +"','"+establecimiento+"','"+nombre1+"','"+nombre2+"','"+apellido1+"','"+apellido2+"','"+email+"','"+departamento+"','"+ciudad+"','"+direccion+"','"+estrato+"','"
					+terminos+"','"+informacion+"','"+fecha+"');";
            stmt.executeUpdate(consult);
            stmt.close();
            con.commit();
            con.close();
			
		}catch(Exception ex){
			Logger.getLogger(usuarioPersistence.class.getName()).log(Level.SEVERE, null, ex);
		}	
	}
	
	/**
	 * Actualiza la informacion del usuario 
	 * @param datos a actulizar del usuario
	 */
	public void updateUser(String establecimiento, String nombre1, String nombre2,
			String apellido1, String apellido2,String departamento,String ciudad,String direccion,int estrato) {
		Statement stmt = null;
		try {
			
			Class.forName("org.postgresql.Driver");
			getConection();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			String consult = "update usuario set establecimiento = '"+establecimiento+"',nombre1 ='"+nombre1+"',nombre2='"+nombre2+"',apellido1 ='"+apellido1+"',apellido2 = '"+apellido2+"',departamento='"+departamento+"',ciudad='"+ciudad
					+"',direccion = '"+direccion+"',estrato='"+estrato+"');";
			stmt.executeUpdate(consult);
            stmt.close();
            con.commit();
            con.close();
		}catch(Exception ex){
			Logger.getLogger(usuarioPersistence.class.getName()).log(Level.SEVERE, null, ex);
		}	
	}
	
}
