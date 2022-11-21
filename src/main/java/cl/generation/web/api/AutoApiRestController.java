package cl.generation.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Auto;
import cl.generation.web.models.Usuario;
import cl.generation.web.services.AutoServiceImpl;
import cl.generation.web.services.UsuarioServiceImpl;

@RestController
public class AutoApiRestController {
	
	@Autowired
	private AutoServiceImpl autoServiceImpl;
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl; //inyeccion de los metodos que están en UsuarioService
	
	
	@RequestMapping ("/guardar/auto")
	public Auto guardarAuto(@RequestBody Auto auto, @RequestParam(value="usuarioId", required = false) Long usuarioId) {
		
		// http://localhost:8080/guardar/auto
		
		Usuario usuario = usuarioServiceImpl.obtenerUsuario(usuarioId); 
		
		auto.setUsuario(usuario); //hay que crear un getter y setter para el atributo 'usuario' en Auto.java, así asignamos un usuario
		
		return autoServiceImpl.guardarAuto(auto);
		
	}
	
	@RequestMapping("eliminar/auto")
	public String eliminarAuto(@RequestParam(value="id", required = false) Long id) {
		
		// http://localhost:8080/eliminar/auto
		
		return autoServiceImpl.eliminarAuto(id);
	}
	
	@RequestMapping("/actualizar/auto")
	public String actualizarAuto(@RequestBody Auto auto) {
		
		// http://localhost:8080/actualizar/auto
		autoServiceImpl.actualizarAuto(auto);
		
		return "Usuario actualizado en la base de datos";
		
	}
	
	@RequestMapping("obtener/auto")
	public Auto obtenerAuto(@RequestParam(value="id", required = true) Long id) {
		
		return autoServiceImpl.obtenerAuto(id);
	}
	
	
	

}
