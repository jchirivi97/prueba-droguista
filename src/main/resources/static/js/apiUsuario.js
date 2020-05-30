//mediante jquery se realiza la conexion al backend para solicitar las diferentes peticiones
var apiUsuario = (function() {
	return {
		getAllUsers : function(callback) {
			jQuery.ajax({
				url : "/usuario/all",
				type : "GET",
				success : function(datos) {
					callback(datos);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("Error no hay registros");
				}
			})
		},
		getUser : function(email, callback) {
			jQuery.ajax({
				url : "/usuario/" + email,
				type : "GET",
				success : function(datos) {
					callback(datos);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("Error no hay registros del usuario a consultar");
				}
			})
		},
		saveUser : function(usuario) {
			jQuery.ajax({
				url : "/usuario",
				type : "POST",
				data : JSON.stringify(usuario),
				contentType : "application/json",
				success : function() {
					alert("Usuario registrado correctamente");
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("Error no fue posible realizar el registro");
				}
			})
		},
		updateUser : function(usuario) {
			jQuey.ajax({
				url : "/usuario/update",
				type : "PUT",
				data : JSON.stringify(usuario),
				contentType : "application/json",
				success : function() {
					alert("Usuario actualizado correctamente");
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("Error no fue posible realizar la actualización");
				}
			})
		}
	}
})();