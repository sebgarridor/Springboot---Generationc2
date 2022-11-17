package cl.generation.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("eliminar/usuario")
	public String eliminarUsuario(@RequestParam(value="id", required = false) Long id) {  //misma idea que al eliminar el usuario, sólo que aquí capturamos el id de tipo 'long'
		
		//llamando al método eliminar en el servicio
		/* String respuesta = usuarioServiceImpl.eliminarUsuario(id); */
		
		
		
		return usuarioServiceImpl.eliminarUsuario(id);
		
	}
	
	@RequestMapping ("/actualizar/usuario")
	public String actualizarUsuario(@RequestBody Usuario usuario) {
		
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
		
		// validación lógica, si es que viene el campo
		if(usuario.getId()!=null) { //si viene el id, actualiza
			String mensaje = usuarioServiceImpl.actualizarUsuario(usuario);
			return mensaje;
		}
		return "No se actualizara ningun usuario";
	}
	
	@RequestMapping ("/obtener/usuario")
	
	// http://localhost:8080/obtener/usuario
	public Usuario obtenerUsuario(@RequestParam(value="id", required = true) Long id) {
		
		return usuarioServiceImpl.obtenerUsuario(id);
	}
	
	//listar todos los usuarios
	@GetMapping("/listar/usuarios")
	public List<Usuario> obtenerListaUsuarios(){
		return usuarioServiceImpl.obtenerListaUsuarios();
	}
	

}
