package cl.generation.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generation.web.models.Usuario;
import cl.generation.web.repositories.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	//Logica de negocio del sistema web
	@Autowired //facilita la inyeccion
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
		
		//hacemos llamado al método guardar
		return usuarioRepository.save(usuario);
	}

	@Override
	public String eliminarUsuario(Long id) { //se nos obliga a implementar todos los metodos de la interfaz
		
		Boolean existe = usuarioRepository.existsById(id); //creamos variable boolean para comprobar si existe id.
		
		if(existe) {
			//elimino el usuario pasando el id (PK)
			usuarioRepository.deleteById(id);
			
		}else { //creamos un else para decir que si el usuario no existe, retorna un mensaje de no existencia.
			return "Usuario no existe en la tabla";
		}
		
		existe = usuarioRepository.existsById(id); //hay que preguntar de nuevo por la existencia
		
		
		//si es distinto de nulo, significa que el usuario no fue eliminado
		if(existe) {
			return "Usuario no eliminado";
			
		}
		return "El usuario fue eliminado";
	}

	@Override
	public String actualizarUsuario(Usuario usuario) {
		
		
		
		Boolean existe = usuarioRepository.existsById(usuario.getId());
		
		if(existe) { //si el usuario existe, lo actualizamos, de lo contrario, lo crea.
			usuarioRepository.save(usuario);
			return "El usuario ha sido actualizado";
		}
		
		return "Usuario creado";
	}
	
	@Override
	public Usuario obtenerUsuario(Long id) {
		//Optional<Usuario> user = usuarioRepository.findById(id);
		
		Boolean existe = usuarioRepository.existsById(id);
		
		if(existe) {Usuario user = usuarioRepository.findById(id).get(); //con el .get obtenemos el tipo de dato específico y eso retorna
			return user;
			
		}
		
		return null;
		}

	
	//listar todos los usuarios
	@Override
	public List<Usuario> obtenerListaUsuarios() {
		
		//obtenemos TODOS los usuarios
		
		return usuarioRepository.findAll();
	}
	

	

		
	

}
