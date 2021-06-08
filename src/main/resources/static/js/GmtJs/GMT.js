
function pageSize(opcion){
		var pageSize;

		switch(opcion){
			case 1: //Estudiante
				 pageSize=$('#cmbtamanioPaginaEstudiante').val();
				 window.location.replace("/Estudiante/Paginado/?pageSize=" + pageSize + "&page=1");
				break;
			case 2: //Instructor
				pageSize=$('#cmbtamanioPaginaInstructor').val();
				 window.location.replace("/Instructor/Paginado/?pageSize=" + pageSize + "&page=1");
				break;
			case 3: //Curso
				pageSize=$('#cmbtamanioPaginaCurso').val();
				 window.location.replace("/Curso/Paginado/?pageSize=" + pageSize + "&page=1");
				break;
			case 4: //Certificado
				pageSize=$('#cmbtamanioPaginaCertificado').val();
				 window.location.replace("/Certificado/Paginado/?pageSize=" + pageSize + "&page=1");
				break;
			case 5: //Maquina
				pageSize=$('#cmbtamanioPaginaMaquina').val();
				 window.location.replace("/Maquina/Paginado/?pageSize=" + pageSize + "&page=1");
				break;
		}
	
	}

	//GUARDAR

function guardarEstudiante(){
		
	
		if($("#frmEstudiante").valid())
		{
			var Estudiante={
					
					dni:$('#dni').val(),
					nombres:$('#nombres').val(),
					apellidos:$('#apellidos').val(),
					direccion:$('#direccion').val(),
					telefono:$('#telefono').val(),
					correoElectronico:$('#correoElectronico').val(),
					fechaNacimiento:$('#fechaNacimiento').val()
			}
			
			$.ajax({
		        type: 'POST',
		        url: "/Estudiante/Guardar",
		        data:{
		        	Estudiante:JSON.stringify(Estudiante)
		        	},
		        datatype: 'json',
		        success: function (response) {
		        	
		        	swal({
	    				  title: "Correcto!",
	    				  text: "Registro  guardado correctamente!",
	    				  icon: "success",
	    				  button: "Aceptar",
	    				  timer: 2000
	    				}).then(	
    						function () {
    							  if (true) {
    								 window.location="/Estudiante/Paginado";
    							  }
    						}
						)
		        	
				        },
			            error : function() {
			                alert("error");
			            }	 
				 });
			
		}

		
	}
	
	
function guardarInstructor(){
		
		if($("#frmInstructor").valid())
		{
			var Instructor={
					
					dni:$('#dni').val(),
					nombres:$('#nombres').val(),
					apellidos:$('#apellidos').val(),
					especialidad:$('#especialidad').val(),
					telefono:$('#telefono').val(),
					correoElectronico:$('#correoElectronico').val(),
					direccion:$('#direccion').val()
			}
			
			$.ajax({
		        type: 'POST',
		        url: "/Instructor/Guardar",
		        data:{
		        	Instructor:JSON.stringify(Instructor)
		        	},
		        datatype: 'json',
		        success: function (response) {
		        	swal({
	    				  title: "Correcto!",
	    				  text: "Registro guardado correctamente!",
	    				  icon: "success",
	    				  button: "Aceptar",
	    				  timer: 2000
	    				}).then(	
    						function () {
    							  if (true) {
    								 window.location="/Instructor/Paginado";
    							  }
    						}
						)
		        	
				        },
			            error : function() {
			                alert("error");
			            }	 
				 });
			
		}

		
	}


	function guardarCurso(){
		
		
		
		if($("#frmCurso").valid())
		{
			var Curso={
					
					id:$('#id').val(),
					nombre:$('#nombre').val(),
					nivel:$('#nivel').val(),
					horas:$('#horas').val(),
					tipoDeCurso:$('#tipoDeCurso').val(),
					descripcion:$('#descripcion').val(),
					instructor:{
						dni:$('#dniInstructor').val(),
					},
					horario:{
						id:$('#idHorario').val(),
						dia:$('#dia').val(),
						turno:$('#turno').val()
					},
					certificado:{
						id:$('#idCertificado').val()
					}
				}
	
			$.ajax({
		        type: 'POST',
		        url: "/Curso/Guardar",
		        data:{
		        	Curso:JSON.stringify(Curso)
		        	},
		        datatype: 'json',
		        success: function (response) {
		        	swal({
	    				  title: "Correcto!",
	    				  text: "Registro guardado correctamente!",
	    				  icon: "success",
	    				  button: "Aceptar",
	    				  timer: 2000
	    				}).then(	
							function () {
								  if (true) {
									 window.location="/Curso/Paginado";
								  }
							}
						)
		        	
				        },
			            error : function() {
			                alert("error");
			            }	 
				 });
			
		}
		
	}


	function guardarCertificado(){
		
		if($("#frmCertificado").valid())
		{
			var Certificado={
					
				id:$('#id').val(),
				nombreInstitucion:$('#nombreInstitucion').val(),
				especialidad:$('#especialidad').val(),
				fecha:$('#fecha').val()
			}
	
			$.ajax({
		        type: 'POST',
		        url: "/Certificado/Guardar",
		        data:{
		        	Certificado:JSON.stringify(Certificado)
		        	},
		        datatype: 'json',
		        success: function (response) {
		        	swal({
	    				  title: "Correcto!",
	    				  text: "Registro guardado correctamente!",
	    				  icon: "success",
	    				  button: "Aceptar",
	    				  timer: 2000
	    				}).then(	
							function () {
								  if (true) {
									 window.location="/Certificado/Paginado";
								  }
							}
						)
		        	
				        },
			            error : function() {
			                alert("error");
			            }	 
				 });
			
		}
		
	}
	
	function guardarMaquina(){
		
		if($("#frmMaquina").valid())
		{
			var Maquina={
					
				id:$('#id').val(),
				tipoDeMaquina:$('#tipoDeMaquina').val(),
				descripcion:$('#descripcion').val()
			}
	
			$.ajax({
		        type: 'POST',
		        url: "/Maquina/Guardar",
		        data:{
		        	Maquina:JSON.stringify(Maquina)
		        	},
		        datatype: 'json',
		        success: function (response) {
		        	swal({
	    				  title: "Correcto!",
	    				  text: "Registro guardado correctamente!",
	    				  icon: "success",
	    				  button: "Aceptar",
	    				  timer: 2000
	    				}).then(	
							function () {
								  if (true) {
									 window.location="/Maquina/Paginado";
								  }
							}
						)
		        	
				        },
			            error : function() {
			                alert("error");
			            }	 
				 });
			
		}
		
	}
	
	function guardarInscripcion(){
		
		var idMaquina=$('input[name="maquina"]:checked').attr('id');
		var idCurso= $('.lst-cursos a.active').attr('id');
		var idTurno=0;
		var idPromocion='';
		var dniEstudiante=$('#txtDni').val();
		
		console.log("dni:"+dniEstudiante);
		
	}
	

	//ELIMINACION 
	
	$(document).on('click', '#borrarEstudiante', function (event) {
		
		var dniEstudiante='';
		$(this).parents("tr").find("#dniEstudiante").each(function() {
			dniEstudiante = $(this).html();
	    });
		
		event.preventDefault();
		swal({
			  title: "¿Desea eliminar este registro?",
			  text: "No podras volver a visualizar este registro",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  
				  $.ajax({
				        type: 'POST',
				        url: "Eliminar",
				        data:{
				        	dni:dniEstudiante},
				        datatype: 'json',
				        success: function (response) {
				        	
				        	  swal("El registro se ha removido correctamente!", {
				        		  title: "Correcto",
				           	      icon: "success",
				           	   	  timer: 2000
			    				}).then(	
		  						function () {
		  							  if (true) {
		  								window.location.reload();
		  							  }
		  						})
				        },
			            error : function() {
			                //alert("error");
			            }
				  });  
			  } 
			});

	});
	
	
	$(document).on('click', '#borrarInstructor', function (event) {
			
			var dniEstudiante='';
			$(this).parents("tr").find("#dniInstructor").each(function() {
				dniInstructor = $(this).html();
		    });
			
			event.preventDefault();
			swal({
				  title: "¿Desea eliminar este registro?",
				  text: "No podras volver a visualizar este registro",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((willDelete) => {
				  if (willDelete) {
					  
					  $.ajax({
					        type: 'POST',
					        url: "Eliminar",
					        data:{
					        	dni:dniInstructor},
					        datatype: 'json',
					        success: function (response) {
					        	
					        	  swal("El registro se ha removido correctamente!", {
					        		  title: "Correcto",
					           	      icon: "success",
					           	   	  timer: 2000
				    				}).then(	
			  						function () {
			  							  if (true) {
			  								window.location.reload();
			  							  }
			  						})
					        },
				            error : function() {
				                //alert("error");
				            }
					  });  
				  } 
				});
	
		});
	
	$(document).on('click', '#borrarCurso', function (event) {
		
		var idCurso='';
		$(this).parents("tr").find("#idCurso").each(function() {
			idCurso = $(this).html();
	    });
		event.preventDefault();
		swal({
			  title: "¿Desea eliminar este registro?",
			  text: "No podras volver a visualizar este registro",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  
				  $.ajax({
				        type: 'POST',
				        url: "Eliminar",
				        data:{
				        	id:idCurso},
				        datatype: 'json',
				        success: function (response) {
				        	
				        	  swal("El registro se ha removido correctamente!", {
				        		  title: "Correcto",
				           	      icon: "success",
				           	   	  timer: 2000
			    				}).then(	
		  						function () {
		  							  if (true) {
		  								window.location.reload();
		  							  }
		  						})
				        },
			            error : function() {
			                //alert("error");
			            }
				  });  
			  } 
			});
		});
	
	$(document).on('click', '#borrarCertificado', function (event) {
			
			var idCertificado='';
			$(this).parents("tr").find("#idCertificado").each(function() {
				idCertificado = $(this).html();
		    });
			event.preventDefault();
			swal({
				  title: "¿Desea eliminar este registro?",
				  text: "No podras volver a visualizar este registro",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((willDelete) => {
				  if (willDelete) {
					  
					  $.ajax({
					        type: 'POST',
					        url: "Eliminar",
					        data:{
					        	id:idCertificado},
					        datatype: 'json',
					        success: function (response) {
					        	
					        	  swal("El registro se ha removido correctamente!", {
					        		  title: "Correcto",
					           	      icon: "success",
					           	   	  timer: 2000
				    				}).then(	
			  						function () {
			  							  if (true) {
			  								window.location.reload();
			  							  }
			  						})
					        },
				            error : function() {
				                //alert("error");
				            }
					  });  
				  } 
				});
			});
	
		$(document).on('click', '#borrarMaquina', function (event) {
				
				var idMaquina='';
				$(this).parents("tr").find("#idMaquina").each(function() {
					idMaquina = $(this).html();
			    });
				event.preventDefault();
				swal({
					  title: "¿Desea eliminar este registro?",
					  text: "No podras volver a visualizar este registro",
					  icon: "warning",
					  buttons: true,
					  dangerMode: true,
					})
					.then((willDelete) => {
					  if (willDelete) {
						  
						  $.ajax({
						        type: 'POST',
						        url: "Eliminar",
						        data:{
						        	id:idMaquina},
						        datatype: 'json',
						        success: function (response) {
						        	
						        	  swal("El registro se ha removido correctamente!", {
						        		  title: "Correcto",
						           	      icon: "success",
						           	   	  timer: 2000
					    				}).then(	
				  						function () {
				  							  if (true) {
				  								window.location.reload();
				  							  }
				  						})
						        },
					            error : function() {
					                //alert("error");
					            }
						  });  
					  } 
					});
				});
		
		
		//BUSCAR
		
		function buscarEstudiante(){
			
			
			var dni=$('#txtDni').val();
		    
			if(dni!='')
			{
					
				  $.ajax({
				        type: 'POST',
				        url: "BuscarEstudiante",
				        data: {
				        	dni:dni
				        },
				        datatype: 'json',
				        success: function (response) {

				        	
				        	var data = jQuery.parseJSON(response);
				        	console.log(data);
					         
					         $('#txtApellidos').val(data['apellidos']);
					         $('#txtNombres').val(data['nombres']);
					         $('#txtDate').val(data['fechaNacimiento']);
					         $('#txtTelefono').val(data['telefono']);
					         $('#txtDireccion').val(data['direccion']);

					     }
					})
				
			}else{
				swal("Advertencia", {
	        		  title: "Ingresa un dni por favor...",
	           	      icon: "warning",
	           	   	  timer: 2000
  				}).then()
				
			}

			
		}
		
		$(".list-group-item").click(function(){

			   var listItems = $(".list-group-item"); //Select all list items
			
			   //Remove 'active' tag for all list items
			   for (let i = 0; i < listItems.length; i++) {   
				   
			      listItems[i].classList.remove("active");
			      listItems[i].classList.remove("text-white");
			   }
			
			   //Add 'active' tag for currently selected item
			   this.classList.add("active");
			   this.classList.add("text-white");

			});
	

		
		
		
	
		
		$(document).ready(function() {
			
			
			  jQuery.extend(jQuery.validator.messages, {
			  required: "Este campo es obligatorio.",
			  remote: "Por favor, rellena este campo.",
			  email: "Por favor, escribe una dirección de correo válida",
			  url: "Por favor, escribe una URL válida.",
			  date: "Por favor, escribe una fecha válida.",
			  dateISO: "Por favor, escribe una fecha (ISO) válida.",
			  number: "Por favor, escribe un número entero válido.",
			  digits: "Por favor, escribe sólo dígitos.",
			  creditcard: "Por favor, escribe un número de tarjeta válido.",
			  equalTo: "Por favor, escribe el mismo valor de nuevo.",
			  accept: "Por favor, escribe un valor con una extensión aceptada.",
			  maxlength: jQuery.validator.format("Por favor, no escribas más de {0} caracteres."),
			  minlength: jQuery.validator.format("Por favor, no escribas menos de {0} caracteres."),
			  rangelength: jQuery.validator.format("Por favor, escribe un valor entre {0} y {1} caracteres."),
			  range: jQuery.validator.format("Por favor, escribe un valor entre {0} y {1}."),
			  max: jQuery.validator.format("Por favor, escribe un valor menor o igual a {0}."),
			  min: jQuery.validator.format("Por favor, escribe un valor mayor o igual a {0}.")
			});
			  
			  
			
		});
		
		
			