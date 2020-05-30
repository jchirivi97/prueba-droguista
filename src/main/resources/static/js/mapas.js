// ubica una dirección espefecifica en el mapa
function verUbicacion() {
	var coord = {
		lat : 4.7148432,
		lng : -74.0748066
	};

	var informacion;
	var marker;
	var email = sessionStorage.getItem("email");

	var geocoder = new google.maps.Geocoder();

	var maps = new google.maps.Map(document.getElementById("mapa"), {
		zoom : 16,
		scrollwheel : true,
		center : coord
	});

	apiUsuario.getUser(email, markerUser);

	function markerUser(datos) {
		informacion = '<h1>' + datos.establecimiento
				+ '</h1>' + '<p> Dirección: '
				+ datos.direccion + '</p>' + '<p> Propietario: '
				+ datos.nombre1 + " " + datos.apellido1 + '</p>';
		
		// mostrar al usuario en el mapa mediante la direccion
		geocoder
				.geocode(
						{
							'address' : datos.direccion + " , " + datos.ciudad
						},
						function(results, status) {
							if (status == 'OK') {
								var resultados = results[0].geometry.location, resultados_lat = resultados
										.lat(), resultados_long = resultados
										.lng();

								maps.setCenter(results[0].geometry.location);
								marker = new google.maps.Marker({
									map : maps,
									position : results[0].geometry.location,
									title: "Tienda: "+datos.establecimiento
								});
								var infowindow = new google.maps.InfoWindow({
									content : informacion
								});
								marker.addListener('click',function(){
									informacion.open(maps,marker);
								});
							}
						});		
	}

}
