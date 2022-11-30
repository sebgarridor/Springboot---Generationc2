package cl.generation.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Rol;
import cl.generation.web.models.Usuario;
import cl.generation.web.services.RolServiceImpl;

@RestController
public class RolApiRestController {
	
	@Autowired
	private RolServiceImpl rolServiceImpl;
	
	@RequestMapping("obtener/rol")
	public Rol obtenerRol(@RequestParam(value="id", required = true) Long id) {
		Rol rol = rolServiceImpl.obtenerRol(id);
		
		//uso de LAZY
		List <Usuario> usuarios = rol.getUsuarios(); //obtener la lista de todos los usuarios
		for (Usuario usuario : usuarios) { //recorro la lista de todos los usuarios que matcheen el id solicitado
			System.out.println(usuario.getNombre()); //obtengo todos los nombres del rol consultado a través del postman
			
		}
		return rol;
	}

}
