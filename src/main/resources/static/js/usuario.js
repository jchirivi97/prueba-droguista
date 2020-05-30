var usuarioActions = (function() {

	var allTiendas = function() {
		apiUsuario.getAllUsers(verTienda);
	}

	var verTienda = function(datos) {
		if (datos != 0) {
			datos
					.map(function(tienda) {
						var column =

						'<tr><th scope="row">'
								+ tienda.establecimiento
								+ '</th>'
								+ '<td>'
								+ tienda.direccion
								+ '</td>'
								+ '<td>'
								+ tienda.ciudad
								+ '</td>'
								+ '<td>'
								+ '<button type="button" class="btn btn-danger" onclick="usuarioActions.mapa(\''
								+ tienda.email
								+ '\')">Ver ubicacion</button>' + '</td>'
								+ '<td>'
								+ '<button type="button" class="btn btn-danger" onclick="usuarioActions.actualizar(\''
								+ tienda.email
								+ '\')">Actualizar</button>'
								+ '</td>'
								+ '</tr>'
						$("table tbody").append(column);
					})
		}
	}

	var ubicacion = function(dato) {
		sessionStorage.setItem("email", dato);
		location.href = "/maps.html";
	}
	
	var updateUser = function(dato) {
		sessionStorage.setItem("email", dato);
		location.href = "/actualizar.html";
	}
	
	
	var updateProceso = function(){
		var consult = sessionStorage.getItem("email");
		apiUsuario.getUser(consult,actualizarinfo);
	}
	
	var actualizarinfo = function(data){
		//mostrar informacion actual
		$('#establecimiento').val(data.establecimiento);
		$('#nombre1').val(data.nombre1);
		$('#nombre2').val(data.nombre2);
		$('#apellido1').val(data.apellido1);
		$('#apellido2').val(data.apellido2);
		$('#ciudad').val(data.ciudad);
		$('#direccion').val(data.direccion);
	}
	
	var saveUpdate = function(){
		///actualizar informacion
		var usuario = {
			    "identificacion": null,
			    "tipodocumen": null,
			    "establecimiento": document.getElementById("establecimiento").value,
			    "nombre1":document.getElementById("nombre1").value,
			    "nombre2":document.getElementById("nombre2").value,
			    "apellido1":document.getElementById("apellido1").value,
			    "apellido2":document.getElementById("apellido2").value,
			    "email": sessionStorage.getItem("email"),
			    "departamento": document.getElementById("depto").value,
			    "ciudad":document.getElementById("ciudad").value,
			    "direccion":document.getElementById("direccion").value,
			    "estrato": document.getElementById("estrato").value,
			    "fecha": null,
			    "terminos": true,
			    "informacion": true
			  }
		if(document.getElementById("depto").value != "Seleccione..." && document.getElementById("estrato").value != "seleccione..." ){
			apiUsuario.updateUser(usuario);
		}else{
			alert("Recuerde que debe seleccionar el Departamento y Estrato");
		}		
	}
	
	var registarUser = function() {
		var usuario = {
			    "identificacion": document.getElementById("documento").value,
			    "tipodocumen": document.getElementById("tipDoc").value,
			    "establecimiento": document.getElementById("establecimiento").value,
			    "nombre1":document.getElementById("nombre1").value,
			    "nombre2":document.getElementById("nombre2").value,
			    "apellido1":document.getElementById("apellido1").value,
			    "apellido2":document.getElementById("apellido2").value,
			    "email": document.getElementById("email").value,
			    "departamento": document.getElementById("depto").value,
			    "ciudad":document.getElementById("ciudad").value,
			    "direccion":document.getElementById("direccion").value,
			    "estrato": document.getElementById("estrato").value,
			    "fecha": document.getElementById("fechana").value,
			    "terminos": true,
			    "informacion": true
			  }
		apiUsuario.saveUser(usuario);
		alert("Usuario registrado correctamente");
		location.href="/index.html";
	}

	
	return {

		verTiendas : allTiendas,
		mapa : ubicacion,
		crearcuenta : registarUser,
		actualizar : updateUser,
		proceso : updateProceso,
		update : saveUpdate
	}
})();