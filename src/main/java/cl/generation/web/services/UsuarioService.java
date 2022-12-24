package cl.generation.web.services;

import java.util.List;
import java.util.Optional;

import cl.generation.web.models.Usuario;

public interface UsuarioService {
	
	//solo para definir metodos para crud Usuario
	public Boolean guardarUsuario(Usuario usuario);
	
	public String eliminarUsuario(Long id);
	
	public String actualizarUsuario(Usuario usuario);
	
	public Usuario obtenerUsuario(Long id);
	
	public List<Usuario> obtenerListaUsuarios();
	
	
	//login	dasd	
	
	public Boolean ingresarUsuario(String email, String password);
	
	public Usuario obtenerUsuarioEmail(String email);
	

}
