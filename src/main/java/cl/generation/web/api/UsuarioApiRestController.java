package cl.generation.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Usuario;
import cl.generation.web.services.UsuarioServiceImpl;

@RestController
public class UsuarioApiRestController {
	@Autowired //tomamos todos los metodos de clase que vayamos a inyectar, lo hace propio
	private UsuarioServiceImpl usuarioServiceImpl; //vinculando el controlador con el serviceImplement
	
	//Agregamos método para almacenar la data
	@RequestMapping ("/guardar/usuario")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		
		// http://localhost:8080/guardar/usuario
		/*
		 * {
		 * nombre: "Sebastian",
		 * correo: "a@a.cl",
		 * password: "secret123"
		 * 
		 * 
		 * 
		 */
		
		
		return usuarioServiceImpl.guardarUsuario(usuario);// "Usuario guardado";
	}

}
