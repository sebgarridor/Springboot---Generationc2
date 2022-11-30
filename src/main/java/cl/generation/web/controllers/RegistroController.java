package cl.generation.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.generation.web.models.Usuario;
import cl.generation.web.services.UsuarioServiceImpl;

@Controller
@RequestMapping("/registro")
public class RegistroController {
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	//capturar la url y desplegar el .jsp (controlador)
	@RequestMapping("/usuario")
	public String mostrarFormulario() {
		return "registro.jsp";
	}
	//el usuario llena el formulario (vista)
	//enviamos el formulario con el botón 'submit'/'enviar'(vista)
	//capturar la url otra vez http://localhost:8080/registro/formulario
	
	@RequestMapping("/formulario")
	//capturar los parametros @RequestParam
	public String guardarFormulario(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("nick") String nick,
			@RequestParam("correo") String correo,
			@RequestParam("password") String password,
			@RequestParam("password2") String password2) {
		System.out.println(nombre+" "+apellido+" "+correo+" "+nick+" "+password);
		
		//instanciamos un objeto usuario
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setCorreo(correo);
		usuario.setPassword(password);
		usuario.setNick(nick);
		usuario.setPassword2(password2);
		
		// enviar a base de datos
		usuarioServiceImpl.guardarUsuario(usuario);
		
		
		
		return "index.jsp"; //enviar a una vista, para retornar una vista siempre debemos devolver un String
	}

	
	// enviar a base de datos


}
