package cl.generation.web.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
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
	public Boolean guardarUsuario(Usuario usuario) {
		
		
		// validar el usuario (email/correo)
		Usuario retornoUsuario = usuarioRepository.findByCorreo(usuario.getCorreo()); //buscamos por correo a través del método definidio en el repository.
		
		//System.out.println(retornoUsuario.getCorreo());
		
		if(retornoUsuario == null) {
			String passHashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt()); //encriptamos a través de bcrypt. si paso 1234 -> ad123123123jdjdj4 por ej
			//reemplazando el valor por el hash.
			usuario.setPassword(passHashed);
			usuarioRepository.save(usuario); //hacemos llamado al método guardar
			return true;
			
		}else {
			return false;
			
		}
		

		
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

	@Override
	public Boolean ingresarUsuario(String email, String password) {
		System.out.println(email+" "+password);
		
		Usuario usuario = usuarioRepository.findByCorreo(email); //debo ir a buscar la info a la BD a través del repository (encargado de hacer la conexión a la BD)
		if(usuario!= null) { //existe el usuario en la BD
			//comparar las contraseñas
			Boolean resultadoPassword = BCrypt.checkpw(password, usuario.getPassword()); //checkeamos la password encriptada en la BD.
			//resultadoPassword == true; son iguales -> false, no coinciden.
			
			if(resultadoPassword) {
				return true;
				
			}else {
				return false;
			}
			
			//otra vía más corta -> return BCrypt.checkpw(password, usuario.getPassword())
			//sirve para reemplazar todas las validaciones y la creación de la variable booleana 'resultadoPassword'
			
		}else { //no existe el email en el bd
			return false;
		}
		
		
	}
	@Override
	public Usuario obtenerUsuarioEmail(String email) {
		
		return usuarioRepository.findByCorreo(email);
	}
	

	

		
	

}
